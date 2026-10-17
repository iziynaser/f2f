package ir.verjik.repository;

import ir.verjik.entity.Product;
import ir.verjik.entity.ProductMeasure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMeasureRepository extends CrudRepository<ProductMeasure,Long> {

    //@Query("select pm.id,pm.depth,pm.depthType,pm.height,pm.heightType,pm.weight,pm.weightType from ProductMeasure as pm where pm.product.id = ? productId")
    //ProductMeasure findAllByProduct(Product product);

    ProductMeasure findAllByProduct(Product product);

}
