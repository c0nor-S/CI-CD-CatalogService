package ie.atu.CICD.catalog.service;

import ie.atu.CICD.catalog.dto.CreateProductRequest;
import ie.atu.CICD.catalog.model.Category;
import ie.atu.CICD.catalog.model.Product;
import ie.atu.CICD.catalog.repository.CategoryRepository;
import ie.atu.CICD.catalog.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository,  CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Product createProduct(CreateProductRequest request) {
        if (request.categoryId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category ID Is Required");
        }

        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category Not Found"));

        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        product.setCategory(category);

        return productRepository.save(product);

    }
    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found With ID: "));
    }

    public List<Product> getByMinimumPrice(BigDecimal minPrice) {
        return productRepository.findByMinimumPrice(minPrice);
    }
}
