package com.f2f.service.product;

import com.f2f.dao.product.ProductPriceDao;
import com.f2f.entity.product.Product;
import com.f2f.entity.product.ProductPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductPriceService {

    @Autowired
    ProductPriceDao productPriceDao;

    public ProductPrice save(ProductPrice pp){
        ProductPrice productPrice = productPriceDao.save(pp);
        return productPrice;
    }

    public List<ProductPrice> findAll(){
        List<ProductPrice> productPrices = (List<ProductPrice>) productPriceDao.findAll();
        return productPrices;
    }

    public List<ProductPrice> getListOfProductPrices(Product product){
        //return productPriceDao.getProductPricesList(product);
        return productPriceDao.findAllByProduct(product);
    }
}
