package com.f2f.service;

import com.f2f.entity.common.ProductColorDTO;
import com.f2f.dao.ProductColorDao;
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
