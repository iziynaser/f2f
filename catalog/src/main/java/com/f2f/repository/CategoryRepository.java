package com.f2f.repository;

import com.f2f.entity.Category;
import com.f2f.dbc.entity.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByParentCategory(Category parent);

    List<Category> findByCategoryType(CategoryType type);

    List<Category> findByParentCategoryAndCategoryType(Category parent, CategoryType type);

}
