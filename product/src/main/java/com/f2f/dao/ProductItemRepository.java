package com.f2f.dao;

import com.f2f.dto.ProductPriceStats;
import com.f2f.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {

    @Query("SELECT pi FROM ProductItem pi " +
            "WHERE pi.product.name LIKE %:productName% " +
            "AND pi.color.name = :colorName " +
            "AND pi.defaultPrice BETWEEN :minPrice AND :maxPrice " +
            "AND pi.available = true")
    List<ProductItem> findAvailableItemsByProductNameAndColorAndPriceRange(
            @Param("productName") String productName,
            @Param("colorName") String colorName,
            @Param("minPrice") Long minPrice,
            @Param("maxPrice") Long maxPrice);

    List<ProductItem> findProductItemByProductId(Long productId);

    @Query(" SELECT pi.product.id as productId, MIN(pi.defaultPrice) as minPrice FROM ProductItem pi WHERE pi.product.id = :productId GROUP BY pi.product.id")
    ProductPriceStats findMinPriceStatsByProductId(Long productId);

    @Query(" SELECT pi.product.id as productId, MAX(pi.defaultPrice) as maxPrice FROM ProductItem pi WHERE pi.product.id = :productId GROUP BY pi.product.id")
    ProductPriceStats findMaxPriceStatsByProductId(Long productId);

    @Query(" SELECT pi.product.id as productId, AVG(pi.defaultPrice) as avgPrice FROM ProductItem pi WHERE pi.product.id = :productId GROUP BY pi.product.id")
    ProductPriceStats findAvgPriceStatsByProductId(Long productId);

    @Query("SELECT DISTINCT b.name FROM ProductItem pi JOIN pi.brand b WHERE pi.product.id = :productId")
    List<String> findDistinctBrandsByProductId(Long productId);

    @Query("SELECT DISTINCT c.name FROM ProductItem pi JOIN pi.color c WHERE pi.product.id = :productId")
    List<String> findDistinctColorsByProductId(Long productId);
}
