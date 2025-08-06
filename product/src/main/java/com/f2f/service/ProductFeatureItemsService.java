package com.f2f.service;

import com.f2f.entity.ProductFeatureItem;
import com.f2f.entity.ProductFeatureValue;
import com.f2f.repository.ProductFeatureValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductFeatureItemsService {

    @Autowired
    ProductFeatureValueRepository productFeatureValueRepository;

    public ProductFeatureValue save(ProductFeatureValue items, ProductFeatureItem productFeatureItem){
        String featureItemsName = productFeatureValueRepository.findProductFeatureItemsByName(items.getName(),productFeatureItem);
        if(featureItemsName==null){
            ProductFeatureValue item = productFeatureValueRepository.save(items);
            return item;
        }else
            return items;
    }

    public List<ProductFeatureValue> loadProductFeatureItemsByFeatureItem(ProductFeatureItem productFeatureItem) {
        return productFeatureValueRepository.findByFeatureItemOrderByOrders(productFeatureItem);
    }

}
