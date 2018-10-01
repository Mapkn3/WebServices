package my.mapkn3.Orders.service;

import my.mapkn3.Orders.model.Product;

import java.util.List;

public interface ProductService {
    Product getProduct(String serialNumber);

    String addNewProduct(Product product);

    List<Product> getAllProduct();

    Product updateProduct(Product product);

    void deleteProduct(Product product);

    void synchronizeProductsFromFile(String pathToXml);
}
