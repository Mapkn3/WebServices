package my.mapkn3.Orders.service;

import my.mapkn3.Orders.dao.PrettyEntityDao;
import my.mapkn3.Orders.model.Product;
import my.mapkn3.Orders.model.Products;
import org.apache.log4j.Logger;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private static final Logger logger = Logger.getLogger(ProductServiceImpl.class);

    @Autowired
    private PrettyEntityDao productDao;

    @Transactional(readOnly = true)
    @Override
    public Product getProduct(String serialNumber) {
        logger.debug("Getting product with serial number: " + serialNumber);
        return productDao.findById(Product.class, serialNumber);
    }

    @Override
    public String addNewProduct(Product product) {
        String serialNumber = (String) productDao.save(product);
        logger.debug("Serial number of new product: " + serialNumber);
        return serialNumber;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> getAllProduct() {
        List<Product> products = productDao.getAll(Product.class);
        logger.debug("Get " + products.size() + " products:\n");
        products.forEach(logger::debug);
        return products;
    }

    @Override
    public Product updateProduct(Product product) {
        Product oldProduct = productDao.findById(Product.class, product.getSerialNumber());
        Product newProduct = productDao.update(product);
        logger.debug("Old product: " + oldProduct);
        logger.debug("New product: " + newProduct);
        return newProduct;
    }

    @Override
    public void deleteProduct(Product product) {
        logger.debug("Delete product: " + product);
        productDao.delete(product);
    }

    @Override
    public void synchronizeProductsFromFile(String pathToXml) {
        try {
            IBindingFactory bindingFactory = BindingDirectory.getFactory(Products.class);
            IUnmarshallingContext unmarshallingContext = bindingFactory.createUnmarshallingContext();
            Products products  = (Products) unmarshallingContext.unmarshalDocument(new FileReader(pathToXml));
            for (Product product : products.getProducts()) {
                if (productDao.findById(Product.class, product.getSerialNumber()) != null) {
                    productDao.update(product);
                } else {
                    productDao.save(product);
                }
            }
        } catch (JiBXException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
