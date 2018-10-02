package my.mapkn3.Orders;

import my.mapkn3.Orders.model.Products;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws JiBXException, FileNotFoundException {
        IBindingFactory bindingFactory = BindingDirectory.getFactory(Products.class);
        IUnmarshallingContext unmarshallingContext = bindingFactory.createUnmarshallingContext();
        Products products  = (Products) unmarshallingContext.unmarshalDocument(new FileReader("D:\\IdeaProjects\\Orders\\src\\main\\java\\my\\mapkn3\\Orders\\data.xml"));
        products.getProducts().forEach(System.out::println);
    }
}
