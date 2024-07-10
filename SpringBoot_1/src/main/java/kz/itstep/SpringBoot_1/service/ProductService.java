package kz.itstep.SpringBoot_1.service;

import kz.itstep.SpringBoot_1.model.Product;
import kz.itstep.SpringBoot_1.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final IProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int product_id) {
        Optional<Product> product = productRepository.findById(product_id);
        if (product.isPresent()) {
            return product.get();
        }
        return null;
    }

    @SneakyThrows
    public Product getProductByName(String product_name) {
        Product product = productRepository.findByName(product_name);
        if (product == null) {
            throw new Exception("Product" + product_name + " not found");
        }
        return null;
    }

    public Product createProduct(Product product) {
        if (product != null) {
            return productRepository.save(product);
        }
        return null;
    }

    public Product updateProduct(int product_id, Product product) {
        Optional<Product> oldProduct = productRepository.findById(product_id);
        if (oldProduct.isPresent()) {
            Product updatedProduct = oldProduct.get();
            updatedProduct.setProduct_name(product.getProduct_name());
            updatedProduct.setProduct_price(product.getProduct_price());
            return productRepository.save(updatedProduct);
        }
        return null;
    }

    public boolean deleteProduct(int product_id) {
        Optional<Product> oldProduct = productRepository.findById(product_id);
        if (oldProduct.isPresent()) {
            productRepository.deleteById(product_id);
            return true;
        }
        return false;
    }
}
