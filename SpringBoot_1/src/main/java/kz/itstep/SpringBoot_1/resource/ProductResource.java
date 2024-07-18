package kz.itstep.SpringBoot_1.resource;

import kz.itstep.SpringBoot_1.model.Product;
import kz.itstep.SpringBoot_1.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@RequiredArgsConstructor
@Controller
public class ProductResource {
    private final IProductService productService;

    @GetMapping("/all_products")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products/all_products";
    }
}
