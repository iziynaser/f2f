package com.f2f.service.product;

import com.f2f.dao.product.ProductDao;
import com.f2f.dao.product.ProductKeywordDao;
import com.f2f.entity.product.Product;
import com.f2f.entity.product.ProductKeyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
@PreAuthorize("isAuthenticated()")
public class ProductKeywordService {

    @Autowired
    ProductKeywordDao productKeywordDao;

    @Autowired
    ProductDao productDao ;

    public List<ProductKeyword> findAllByProduct(Long productId){
        Optional<Product> optionalProduct = productDao.findById(productId);
        Product p = optionalProduct.orElseThrow(EntityNotFoundException::new);
        List<ProductKeyword> products = productKeywordDao.findAllByProduct(p);
        return products;
    }

    public ProductKeyword save(ProductKeyword productKeyword){
        ProductKeyword pKeyword = productKeywordDao.save(productKeyword);
        return pKeyword;
    }

}
