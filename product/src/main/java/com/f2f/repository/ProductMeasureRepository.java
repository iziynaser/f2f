package com.f2f.repository;

import com.f2f.entity.Product;
import com.f2f.entity.ProductMeasure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMeasureRepository extends CrudRepository<ProductMeasure,Long> {

    //@Query("select pm.id,pm.depth,pm.depthType,pm.height,pm.heightType,pm.weight,pm.weightType from ProductMeasure as pm where pm.product.id = ? productId")
    //ProductMeasure findAllByProduct(Product product);

    ProductMeasure findAllByProduct(Product product);

}
