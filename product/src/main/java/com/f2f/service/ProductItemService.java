package com.f2f.service;

import com.f2f.dao.ProductItemRepository;
import com.f2f.entity.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@PreAuthorize("isAuthenticated()")
public class ProductItemService {

    @Autowired
    private ProductItemRepository repository;

    List<ProductItem> findProductItemByProductId(Long productId){
        return repository.findProductItemByProductId(productId);
    }

}
