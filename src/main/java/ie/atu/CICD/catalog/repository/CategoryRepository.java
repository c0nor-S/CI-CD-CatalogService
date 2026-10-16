package ie.atu.CICD.catalog.repository;

import ie.atu.CICD.catalog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
