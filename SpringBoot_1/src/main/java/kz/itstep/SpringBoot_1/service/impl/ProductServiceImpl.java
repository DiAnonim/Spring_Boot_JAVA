package kz.itstep.SpringBoot_1.service.impl;

import kz.itstep.SpringBoot_1.exceptions.ProductNotFoundException;
import kz.itstep.SpringBoot_1.exceptions.UserExistException;
import kz.itstep.SpringBoot_1.model.Product;
import kz.itstep.SpringBoot_1.repository.IProductRepository;
import kz.itstep.SpringBoot_1.service.IProductService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final IProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int product_id) {
        Optional<Product> product = productRepository.findById(product_id);
        if (product.isPresent()) {
            return product.get();
        }
        return null;
    }

    @Override
    @SneakyThrows
    public Product getProductByName(String product_name) {
        Product product = productRepository.findByName(product_name);
        if (product == null) {
            throw new ProductNotFoundException("Product" + product_name + " not found");
        }
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        checkProductExist(product.getProduct_name());
        if (product != null) {
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public Product updateProduct(int product_id, Product product) {
        checkProductExist(product.getProduct_name());
        Optional<Product> oldProduct = productRepository.findById(product_id);
        if (oldProduct.isPresent()) {
            Product updatedProduct = oldProduct.get();
            updatedProduct.setProduct_name(product.getProduct_name());
            updatedProduct.setProduct_price(product.getProduct_price());
            return productRepository.save(updatedProduct);
        }
        return null;
    }

    @Override
    public boolean deleteProduct(int product_id) {
        Optional<Product> oldProduct = productRepository.findById(product_id);
        if (oldProduct.isPresent()) {
            productRepository.deleteById(product_id);
            return true;
        }
        return false;
    }

    @SneakyThrows
    private void checkProductExist(String product_name) {
        if (productRepository.findByName(product_name) != null) {
            throw new UserExistException("Product with " + product_name + " already exist");
        }
    }
}
