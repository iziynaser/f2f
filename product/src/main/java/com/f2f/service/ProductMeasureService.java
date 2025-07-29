package com.f2f.service;

import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.entity.Product;
import com.f2f.entity.ProductMeasure;
import com.f2f.repository.ProductMeasureRepository;
import com.f2f.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
//@PreAuthorize("isAuthenticated()")
public class ProductMeasureService {

    @Autowired
    ProductMeasureRepository productMeasureRepository;

    @Autowired
    ProductRepository productDao;

    public ProductMeasure save(ProductMeasure productMeasure){
        ProductMeasure feature = productMeasureRepository.save(productMeasure);
        return feature;
    }

    public ProductMeasure load(String productId) {
        ProductMeasure pm;
        Optional<Product> optionalProduct = productDao.findById(Long.valueOf(productId));
        Product product = optionalProduct.orElseThrow(EntityNotFoundException::new);

        pm = productMeasureRepository.findAllByProduct(product);

        return pm;
    }
}
