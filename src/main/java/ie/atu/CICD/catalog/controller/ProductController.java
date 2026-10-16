package ie.atu.CICD.catalog.controller;

import ie.atu.CICD.catalog.model.Product;
import ie.atu.CICD.catalog.repository.CategoryRepository;
import ie.atu.CICD.catalog.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }
    @PostMapping
    public Product CreateProductRequest(@RequestBody CreateProductRequest request) {
        return productService.createProduct(request);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @GetMapping("/{min-price}")
    public List<Product> getByMinimumPrice(@RequestParam BigDecimal minPrice) {
        return productService.getByMinimumPrice(minPrice);
    }
}
