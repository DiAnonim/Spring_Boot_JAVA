package kz.itstep.SpringBoot_1.service;

import kz.itstep.SpringBoot_1.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAllProducts();
    Product getProductById(int product_id);
    Product getProductByName(String product_name);
    Product createProduct(Product product);
    Product updateProduct(int product_id, Product product);
    boolean deleteProduct(int product_id);
}
