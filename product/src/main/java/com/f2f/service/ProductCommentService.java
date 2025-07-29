package com.f2f.service;


import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.entity.Product;
import com.f2f.repository.ProductCommentsRepository;
import com.f2f.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
//@PreAuthorize("isAuthenticated()")
public class ProductCommentService {

    @Autowired
    ProductCommentsRepository productCommentsRepository;

    @Autowired
    ProductRepository productDao ;

    public int getNumberOfCommentsOnProduct(Long productId){
        Integer count = 0;
        Optional<Product> optionalProduct = productDao.findById(productId);
        Product p= optionalProduct.orElseThrow(EntityNotFoundException::new);
        try{
        count = productCommentsRepository.getCountOfCommentsOnProduct(p.getId());
        }catch (Exception e){
            //log number of comments is zero
        }
        return count;
    }
}
