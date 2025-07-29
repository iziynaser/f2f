package com.f2f.service;

import com.f2f.dto.ProductColorDTO;
import com.f2f.repository.ProductColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductColorService {

    @Autowired
    ProductColorRepository productColorRepository;

    public List<ProductColorDTO> getListOfProductColors(Long productId){
        List<ProductColorDTO> productColorList = productColorRepository.getListOfProductColors(productId);
        return productColorList ;
    }
}
