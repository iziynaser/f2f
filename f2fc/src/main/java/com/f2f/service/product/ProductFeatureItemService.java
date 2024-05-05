package com.f2f.service.product;

import com.f2f.dao.product.ProductFeatureItemDao;
import com.f2f.entity.product.ProductFeatureGroup;
import com.f2f.entity.product.ProductFeatureItem;
import com.f2f.entity.product.ProductFeatureItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductFeatureItemService {

    @Autowired
    ProductFeatureItemDao productFeatureItemDao;

    public ProductFeatureItem save(ProductFeatureItem pfi, ProductFeatureGroup pfg) {
        String featureItemName = productFeatureItemDao.findProductFeatureItemsByName(pfi.getName(),pfg);
        if(featureItemName==null) {
            ProductFeatureItem result = productFeatureItemDao.save(pfi);
            return result;
        }else
            return pfi;
    }

//    public List<ProductFeatureItem> load(Long productFeatureGroupId){
//        List<ProductFeatureItem> pfi = new ProductFeatureItem();
//    }

    public List<ProductFeatureItem> loadProductFeatureItems(ProductFeatureGroup productFeatureGroup){
        List<ProductFeatureItem> productFeatureItemList = productFeatureItemDao.loadProductFeatureItems(productFeatureGroup);
        return productFeatureItemList;
    }
}
