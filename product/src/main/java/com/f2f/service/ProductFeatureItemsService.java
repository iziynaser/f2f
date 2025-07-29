package com.f2f.service;

import com.f2f.entity.ProductFeatureItem;
import com.f2f.entity.ProductFeatureItems;
import com.f2f.repository.ProductFeatureItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductFeatureItemsService {

    @Autowired
    ProductFeatureItemsRepository productFeatureItemsRepository;

    public ProductFeatureItems save(ProductFeatureItems items, ProductFeatureItem productFeatureItem){
        String featureItemsName = productFeatureItemsRepository.findProductFeatureItemsByName(items.getName(),productFeatureItem);
        if(featureItemsName==null){
            ProductFeatureItems item = productFeatureItemsRepository.save(items);
            return item;
        }else
            return items;
    }

    public List<ProductFeatureItems> loadProductFeatureItemsByFeatureItem(ProductFeatureItem productFeatureItem){
        List<ProductFeatureItems> productFeatureItemsList = productFeatureItemsRepository.loadProductFeatureItemsByFeatureItem(productFeatureItem);
        return productFeatureItemsList;
    }

}
