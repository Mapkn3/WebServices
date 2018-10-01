package my.mapkn3.Orders;

import my.mapkn3.Orders.service.ProductServiceImpl;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws JiBXException, FileNotFoundException {
        IBindingFactory bindingFactory = BindingDirectory.getFactory(ProductServiceImpl.Products.class);
        IUnmarshallingContext unmarshallingContext = bindingFactory.createUnmarshallingContext();
        ProductServiceImpl.Products products  = (ProductServiceImpl.Products) unmarshallingContext.unmarshalDocument(new FileReader("data.xml"));
        products.getProducts().forEach(System.out::println);
    }
}
