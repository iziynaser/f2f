package com.f2f.dao.product;

import com.f2f.entity.product.Product;
import com.f2f.entity.product.ProductFeatureGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ProductFeatureGroupDao")
public interface ProductFeatureGroupDao extends JpaRepository<ProductFeatureGroup,Long> {

    List<ProductFeatureGroup> findAll();

    @Query("select g.id as groupId,g.name as groupName,i.id as itemId,i.name as itemName,s.id as itemsId,s.name as itemsName " +
            " from ProductFeatureGroup as g " +
            " left join ProductFeatureItem as i " +
            " on g.id = i.featureGroup " +
            " left join ProductFeatureItems as s on i.id = s.featureItem " +
            " where g.product.id=:id" +
            " order by g.orders,i.orders,s.orders")
    List<FeaturesDTO> getListOfFeatures(@Param("id") Long id);

    @Query("select t from ProductFeatureGroup as t where t.product=:product")
    ProductFeatureGroup loadProductFeatureGroupWithProductId(@Param("product") Product product);

    @Query("select 1 from ProductFeatureGroup as t where t.product=:product")
    int isThereARecordOnProductFeatureGroup(@Param("product") Product product);
}
