package ie.atu.CICD.catalog.repository;

import ie.atu.CICD.catalog.model.Category;
import ie.atu.CICD.catalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("SELECT p FROM Product p JOIN p.category c WHERE LOWER(c.name) = LOWER(:categoryName) ORDER By p.price ASC ")
    List<Product> findByCategoryName(@Param("categoryName") String categoryName);
}
