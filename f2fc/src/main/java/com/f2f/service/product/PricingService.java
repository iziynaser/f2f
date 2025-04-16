package com.f2f.service.product;

import com.f2f.dao.product.PricingDao;
import com.f2f.dao.product.ProductDao;
import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.entity.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PricingService {

    @Autowired
    PricingDao pricingDao ;

    @Autowired
    ProductDao productDao ;

    public int getCountOfOtherSellersOnProduct(Long productId){
        Integer count = 0;
        Optional<Product> optionalProduct = productDao.findById(productId);
        Product p= optionalProduct.orElseThrow(EntityNotFoundException::new);
        count = pricingDao.getCountOfOtherSellersOnProduct(p.getId());
        return count;
    }


}
