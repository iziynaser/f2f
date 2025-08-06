package com.f2f.repository;

import com.f2f.dto.FeaturesDTO;
import com.f2f.entity.Product;
import com.f2f.entity.ProductFeatureGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductFeatureGroupRepository extends JpaRepository<ProductFeatureGroup, Long> {

    List<ProductFeatureGroup> findByProduct_IdOrderByOrders(Long productId);

    List<ProductFeatureGroup> findByProduct_Id(Long productId);

    @Query("""
        select g.id as groupId, g.name as groupName,
               i.id as itemId, i.name as itemName,
               s.id as itemsId, s.name as itemsName
        from ProductFeatureGroup g
        left join ProductFeatureItem i on g = i.featureGroup
        left join ProductFeatureValue s on i = s.featureItem
        where g.product.id = :productId
        order by g.orders, i.orders, s.orders
    """)
    List<FeaturesDTO> getListOfFeatures(@Param("productId") Long productId);

    boolean existsByProduct(Product product);

    Optional<ProductFeatureGroup> findByProduct(Product product);

    @Query("""
        SELECT g.id AS groupId, g.name AS groupName, 
               i.id AS itemId, i.name AS itemName,
               v.id AS valueId, v.name AS valueName
        FROM ProductFeatureGroup g
        LEFT JOIN g.features i
        LEFT JOIN i.featureItems v
        WHERE g.product.id = :productId
        ORDER BY g.orders, i.orders, v.orders
    """)
    List<FeaturesDTO> getFeatureHierarchy(@Param("productId") Long productId);
}
