package com.f2f.dao.product;

import com.f2f.entity.product.Product;
import com.f2f.entity.product.ProductMeasure;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("ProductMeasureDao")
public interface ProductMeasureDao extends CrudRepository<ProductMeasure,Long> {

    //@Query("select pm.id,pm.depth,pm.depthType,pm.height,pm.heightType,pm.weight,pm.weightType from ProductMeasure as pm where pm.product.id = ? productId")
    //ProductMeasure findAllByProduct(Product product);

    ProductMeasure findAllByProduct(Product product);

}
