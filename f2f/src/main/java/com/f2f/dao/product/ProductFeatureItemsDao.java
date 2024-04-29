package com.f2f.dao.product;

import com.f2f.entity.product.ProductFeatureItem;
import com.f2f.entity.product.ProductFeatureItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ProductFeatureItemsDao")
public interface ProductFeatureItemsDao extends JpaRepository<ProductFeatureItems,Long> {

    @Query("select t.name from ProductFeatureItems as t where t.name=:featureItemsName and t.featureItem=:featureItem")
    String findProductFeatureItemsByName(@Param("featureItemsName") String featureItemsName, @Param("featureItem")ProductFeatureItem productFeatureItem);

    @Query("select t from ProductFeatureItems as t where t.featureItem=:productFeatureItem")
    List<ProductFeatureItems> loadProductFeatureItemsByFeatureItem(@Param("productFeatureItem") ProductFeatureItem productFeatureItem);
}
