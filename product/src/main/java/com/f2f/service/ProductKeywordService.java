package com.f2f.service;

import com.f2f.entity.Product;
import com.f2f.entity.ProductKeyword;
import com.f2f.repository.ProductKeywordRepository;
import com.f2f.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
//@PreAuthorize("isAuthenticated()")
public class ProductKeywordService {

    @Autowired
    ProductKeywordRepository productKeywordRepository;

    @Autowired
    ProductRepository productDao ;

    public List<ProductKeyword> findAllByProduct(Long productId){
        Optional<Product> optionalProduct = productDao.findById(productId);
        if(optionalProduct.isPresent()){
            Product p = optionalProduct.get();
            return productKeywordRepository.findAllByProducts(p);
        }
        return null;
    }

    public ProductKeyword save(ProductKeyword productKeyword){
        ProductKeyword pKeyword = productKeywordRepository.save(productKeyword);
        return pKeyword;
    }

}
