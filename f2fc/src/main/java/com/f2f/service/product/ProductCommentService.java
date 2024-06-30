package com.f2f.service.product;

import com.f2f.dao.product.ProductCommentsDao;
import com.f2f.dao.product.ProductDao;
import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.entity.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@PreAuthorize("isAuthenticated()")
public class ProductCommentService {

    @Autowired
    ProductCommentsDao productCommentsDao;

    @Autowired
    ProductDao productDao ;

    public int getNumberOfCommentsOnProduct(Long productId){
        int count = 0;
        Optional<Product> optionalProduct = productDao.findById(productId);
        Product p= optionalProduct.orElseThrow(EntityNotFoundException::new);
        count = productCommentsDao.getCountOfCommentsOnProduct(p.getId());
        return count;
    }
}
