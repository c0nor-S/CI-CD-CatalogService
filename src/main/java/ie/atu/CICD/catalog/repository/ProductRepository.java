package ie.atu.CICD.catalog.repository;

import ie.atu.CICD.catalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
