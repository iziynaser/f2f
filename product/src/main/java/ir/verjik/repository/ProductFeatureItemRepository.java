package ir.verjik.repository;

import ir.verjik.entity.ProductFeatureGroup;
import ir.verjik.entity.ProductFeatureItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductFeatureItemRepository extends JpaRepository<ProductFeatureItem, Long> {

    List<ProductFeatureItem> findByFeatureGroup_IdOrderByOrders(Long groupId);

    boolean existsByNameAndFeatureGroup(String name, ProductFeatureGroup featureGroup);

    List<ProductFeatureItem> findAllByFeatureGroup(ProductFeatureGroup featureGroup);

    @Query("""
        SELECT t.name 
        FROM ProductFeatureItem t 
        WHERE t.name = :featureItemName AND t.featureGroup = :featureGroup
    """)
    String findProductFeatureItemsByName(@Param("featureItemName") String name,
                                         @Param("featureGroup") ProductFeatureGroup featureGroup);

    List<ProductFeatureItem> findByFeatureGroupOrderByOrders(ProductFeatureGroup featureGroup);

    default List<ProductFeatureItem> loadProductFeatureItems(ProductFeatureGroup productFeatureGroup) {
        return findByFeatureGroupOrderByOrders(productFeatureGroup);
    }

    default List<ProductFeatureItem> loadProductFeatureItemsFallback(ProductFeatureGroup productFeatureGroup) {
        return findAllByFeatureGroup(productFeatureGroup);
    }
}
