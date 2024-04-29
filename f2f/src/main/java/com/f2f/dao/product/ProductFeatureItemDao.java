package com.f2f.dao.product;

import com.f2f.entity.product.ProductFeatureGroup;
import com.f2f.entity.product.ProductFeatureItem;
import com.f2f.entity.product.ProductFeatureItemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ProductFeatureItemDao")
public interface ProductFeatureItemDao extends JpaRepository<ProductFeatureItem,Long> {

    ProductFeatureItem findAllByFeatureGroup(ProductFeatureGroup featureGroup);

    @Query("select name from ProductFeatureItem as t where name=:featureItemName and t.featureGroup=:featureGroup ")
    String findProductFeatureItemsByName(@Param("featureItemName") String name,@Param("featureGroup") ProductFeatureGroup featureGroup);

    @Query("select t from ProductFeatureItem  as t where t.featureGroup=:productFeatureGroup")
    List<ProductFeatureItem> loadProductFeatureItems(@Param("productFeatureGroup") ProductFeatureGroup productFeatureGroup);

}
