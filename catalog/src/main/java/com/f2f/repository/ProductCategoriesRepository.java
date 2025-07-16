package com.f2f.repository;

import com.f2f.dto.ProductCategoriesDTO;
import com.f2f.entity.ProductCategories;
import com.f2f.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductCategoriesRepository extends JpaRepository<ProductCategories, Long> {

    List<ProductCategories> findByCategory(Category category);

    ProductCategories getFirstByCategoryIdAndProductId(Long categoryId, Long productId);

    @Query("SELECT pc.category FROM ProductCategories pc WHERE pc.productId = :productId")
    List<Category> getListOfCategoriesRelatedToProduct(@Param("productId") Long productId);

    @Query("SELECT new com.f2f.dto.ProductCategoriesDTO(" +
            "p.productId, p.category.id, p.fromDate, p.toDate, p.description, p.isPrimary) " +
            "FROM ProductCategories p WHERE p.category = :category")
    List<ProductCategoriesDTO> listOfProductsRelatedToThiscategory(@Param("category") Category category);

    void deleteAllByCategory(Category category);

}
