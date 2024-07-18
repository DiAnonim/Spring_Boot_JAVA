package kz.itstep.SpringBoot_1.controller;

import jakarta.validation.Valid;
import kz.itstep.SpringBoot_1.model.Product;
import kz.itstep.SpringBoot_1.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService;

    @GetMapping("/")
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getProductByName(@PathVariable String name) {
        return ResponseEntity.ok(productService.getProductByName(name));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@Valid @RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@Valid @PathVariable int id, @RequestBody Product product) {
        return ResponseEntity.accepted().body(productService.updateProduct(id, product));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        return ResponseEntity.accepted().body(productService.deleteProduct(id));
    }

}
