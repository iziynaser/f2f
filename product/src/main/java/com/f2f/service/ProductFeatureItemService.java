package com.f2f.service;

import com.f2f.entity.ProductFeatureGroup;
import com.f2f.entity.ProductFeatureItem;
import com.f2f.repository.ProductFeatureItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductFeatureItemService {

    @Autowired
    ProductFeatureItemRepository productFeatureItemRepository;

    public ProductFeatureItem save(ProductFeatureItem pfi, ProductFeatureGroup pfg) {
        String featureItemName = productFeatureItemRepository.findProductFeatureItemsByName(pfi.getName(),pfg);
        if(featureItemName==null) {
            ProductFeatureItem result = productFeatureItemRepository.save(pfi);
            return result;
        }else
            return pfi;
    }

//    public List<ProductFeatureItem> load(Long productFeatureGroupId){
//        List<ProductFeatureItem> pfi = new ProductFeatureItem();
//    }

    public List<ProductFeatureItem> loadProductFeatureItems(ProductFeatureGroup productFeatureGroup){
        List<ProductFeatureItem> productFeatureItemList = productFeatureItemRepository.loadProductFeatureItems(productFeatureGroup);
        return productFeatureItemList;
    }
}
