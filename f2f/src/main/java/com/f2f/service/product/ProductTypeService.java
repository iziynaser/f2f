package com.f2f.service.product;

import com.f2f.dao.product.ProductTypeDao;
import com.f2f.entity.product.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ProductTypeService")
public class ProductTypeService {

    @Autowired
    ProductTypeDao productTypeDao;

    public List<ProductType> findAll(){
        List<ProductType> result = (List<ProductType>) productTypeDao.findAll();
        return result;
    }

    public ProductType save(ProductType m) {
        ProductType savedProductType = productTypeDao.save(m);
        return savedProductType;
    }

    public void delete(ProductType m) {
        productTypeDao.delete(m);
    }
}
