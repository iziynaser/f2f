package com.f2f.service.product;

import com.f2f.dao.product.ProductFeatureGroupDao;
import com.f2f.entity.product.Product;
import com.f2f.entity.product.ProductFeatureGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductFeatureGroupService {

    @Autowired
    ProductFeatureGroupDao productFeatureGroupDao;

    public List<ProductFeatureGroup> findAll(){
        List<ProductFeatureGroup> list = productFeatureGroupDao.findAll();
        return list;
    }

    public ProductFeatureGroup save(ProductFeatureGroup featureGroup) {
        ProductFeatureGroup f = productFeatureGroupDao.save(featureGroup);
        return f;
    }

    public ProductFeatureGroup newProductFeatureGroup(Product product){
        ProductFeatureGroup pfg = new ProductFeatureGroup("moshakhasat","moshakhasat",0);
        pfg.setProduct(product);
        productFeatureGroupDao.save(pfg);
        return pfg;
    }

    public ProductFeatureGroup loadProductFeatureGroupWithProductId(Product product){
        ProductFeatureGroup pfg = productFeatureGroupDao.loadProductFeatureGroupWithProductId(product);
        return pfg;
    }

    public int isThereARecordOnProductFeatureGroupForProduct(Product product){
        int count = 0;
        count = productFeatureGroupDao.isThereARecordOnProductFeatureGroup(product);
        return count;
    }
}
