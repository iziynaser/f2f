package com.f2f.service;

import com.f2f.dao.ProductCommentsDao;
import com.f2f.dao.ProductDao;
import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
//@PreAuthorize("isAuthenticated()")
public class ProductCommentService {

    @Autowired
    ProductCommentsDao productCommentsDao;

    @Autowired
    ProductDao productDao ;

    public int getNumberOfCommentsOnProduct(Long productId){
        Integer count = 0;
        Optional<Product> optionalProduct = productDao.findById(productId);
        Product p= optionalProduct.orElseThrow(EntityNotFoundException::new);
        try{
        count = productCommentsDao.getCountOfCommentsOnProduct(p.getId());
        }catch (Exception e){
            //log number of comments is zero
        }
        return count;
    }
}
