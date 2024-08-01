package dev.debjitpal.productservice.repositories;

import dev.debjitpal.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByTitle(String title);
    //Category save(Category category); // if we don't use - (cascade = {CascadeType.PERSIST})
}
