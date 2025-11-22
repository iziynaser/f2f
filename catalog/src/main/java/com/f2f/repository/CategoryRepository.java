package com.f2f.repository;

import com.f2f.entity.Category;
import com.f2f.dbc.entity.CategoryType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByParentCategory(Category parent);

    List<Category> findByCategoryType(CategoryType type);

    List<Category> findByParentCategoryAndCategoryType(Category parent, CategoryType type);

    @Query(
            value = "SELECT * FROM category c WHERE c.parent_category_id IS NULL ORDER BY c.name ASC LIMIT :limit",
            nativeQuery = true
    )
    List<Category> findTopCategoriesWithoutParent(@Param("limit") int limit);


}
