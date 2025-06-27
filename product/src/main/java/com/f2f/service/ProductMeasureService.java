package com.f2f.service;

import com.f2f.dao.ProductDao;
import com.f2f.dao.ProductMeasureDao;
import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.entity.Product;
import com.f2f.entity.ProductMeasure;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
//@PreAuthorize("isAuthenticated()")
public class ProductMeasureService {

    @Autowired
    ProductMeasureDao productMeasureDao;

    @Autowired
    ProductDao productDao;

    public ProductMeasure save(ProductMeasure productMeasure){
        ProductMeasure feature = productMeasureDao.save(productMeasure);
        return feature;
    }

    public ProductMeasure load(String productId) {
        ProductMeasure pm;
        Optional<Product> optionalProduct = productDao.findById(Long.valueOf(productId));
        Product product = optionalProduct.orElseThrow(EntityNotFoundException::new);

        pm = productMeasureDao.findAllByProduct(product);

        return pm;
    }
}
