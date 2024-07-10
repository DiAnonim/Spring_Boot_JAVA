package kz.itstep.SpringBoot_1.controller;

import jakarta.validation.Valid;
import kz.itstep.SpringBoot_1.model.Product;
import kz.itstep.SpringBoot_1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/product_name/{name}")
    public Product getProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    @PostMapping("/create")
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PatchMapping("/update/{id}")
    public Product updateProduct(@Valid @PathVariable int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }
}
