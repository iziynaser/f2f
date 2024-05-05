package com.f2f.service.product;

import com.f2f.dao.product.ProductFeatureItemsDao;
import com.f2f.entity.product.ProductFeatureItem;
import com.f2f.entity.product.ProductFeatureItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductFeatureItemsService {

    @Autowired
    ProductFeatureItemsDao productFeatureItemsDao;

    public ProductFeatureItems save(ProductFeatureItems items,ProductFeatureItem productFeatureItem){
        String featureItemsName = productFeatureItemsDao.findProductFeatureItemsByName(items.getName(),productFeatureItem);
        if(featureItemsName==null){
            ProductFeatureItems item = productFeatureItemsDao.save(items);
            return item;
        }else
            return items;
    }

    public List<ProductFeatureItems> loadProductFeatureItemsByFeatureItem(ProductFeatureItem productFeatureItem){
        List<ProductFeatureItems> productFeatureItemsList = productFeatureItemsDao.loadProductFeatureItemsByFeatureItem(productFeatureItem);
        return productFeatureItemsList;
    }

}
