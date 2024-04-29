package com.f2f.front.service.product;

import com.f2f.entity.common.KeyValues;
import com.f2f.entity.common.ProductColorDTO;
import com.f2f.front.dao.product.ProductColorDao;
import com.f2f.entity.product.ProductColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductColorService {

    @Autowired
    ProductColorDao productColorDao ;

    public List<ProductColorDTO> getListOfProductColors(Long productId){
        List<ProductColorDTO> productColorList = productColorDao.getListOfProductColors(productId);
        return productColorList ;
    }
}
