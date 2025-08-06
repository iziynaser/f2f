package com.f2f.repository;

import com.f2f.entity.ProductFeatureItem;
import com.f2f.entity.ProductFeatureValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductFeatureValueRepository extends JpaRepository<ProductFeatureValue, Long> {

    @Query("""
        SELECT t.name 
        FROM ProductFeatureValue t 
        WHERE t.name = :featureItemsName AND t.featureItem = :featureItem
    """)
    String findProductFeatureItemsByName(@Param("featureItemsName") String featureItemsName,
                                         @Param("featureItem") ProductFeatureItem productFeatureItem);

    boolean existsByNameAndFeatureItem(String name, ProductFeatureItem featureItem);

    List<ProductFeatureValue> findByFeatureItemOrderByOrders(ProductFeatureItem productFeatureItem);
}
