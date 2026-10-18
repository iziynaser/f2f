package ir.verjik.repository;

import ir.verjik.dto.ProductCategoriesDTO;
import ir.verjik.entity.ProductCategories;
import ir.verjik.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductCategoriesRepository extends JpaRepository<ProductCategories, Long> {

    List<ProductCategories> findByCategory(Category category);

    ProductCategories getFirstByCategoryIdAndProductId(Long categoryId, Long productId);

    @Query("SELECT pc.category FROM ProductCategories pc WHERE pc.productId = :productId")
    List<Category> getListOfCategoriesRelatedToProduct(@Param("productId") Long productId);

    @Query("SELECT new ir.verjik.dto.ProductCategoriesDTO(" +
            "p.productId, p.category.id, p.fromDate, p.toDate, p.description, p.isPrimary) " +
            "FROM ProductCategories p WHERE p.category = :category")
    List<ProductCategoriesDTO> listOfProductsRelatedToThiscategory(@Param("category") Category category);

    void deleteAllByCategory(Category category);

    @Query("SELECT pc FROM ProductCategories pc WHERE pc.productId = :productId AND pc.isPrimary = true")
    Optional<ProductCategories> findPrimaryCategory(@Param("productId") Long productId);

    @Query("SELECT pc FROM ProductCategories pc WHERE pc.productId = :productId")
    List<ProductCategories> findByProductId(@Param("productId") Long productId);

}
