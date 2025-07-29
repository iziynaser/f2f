package com.f2f.service;

import com.f2f.entity.Product;
import com.f2f.entity.ProductFeatureGroup;
import com.f2f.repository.ProductFeatureGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductFeatureGroupService {

    @Autowired
    ProductFeatureGroupRepository productFeatureGroupRepository;

    public List<ProductFeatureGroup> findAll(){
        List<ProductFeatureGroup> list = productFeatureGroupRepository.findAll();
        return list;
    }

    public ProductFeatureGroup save(ProductFeatureGroup featureGroup) {
        ProductFeatureGroup f = productFeatureGroupRepository.save(featureGroup);
        return f;
    }

    public ProductFeatureGroup newProductFeatureGroup(Product product){
        ProductFeatureGroup pfg = new ProductFeatureGroup("moshakhasat","moshakhasat",0);
        pfg.setProduct(product);
        productFeatureGroupRepository.save(pfg);
        return pfg;
    }

    public ProductFeatureGroup loadProductFeatureGroupWithProductId(Product product){
        ProductFeatureGroup pfg = productFeatureGroupRepository.loadProductFeatureGroupWithProductId(product);
        return pfg;
    }

    public int isThereARecordOnProductFeatureGroupForProduct(Product product){
        int count = 0;
        count = productFeatureGroupRepository.isThereARecordOnProductFeatureGroup(product);
        return count;
    }
}
