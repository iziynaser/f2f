package com.f2f.service;

import com.f2f.entity.ProductType;
import com.f2f.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ProductTypeService")
public class ProductTypeService {

    @Autowired
    ProductTypeRepository productTypeRepository;

    public List<ProductType> findAll(){
        List<ProductType> result = (List<ProductType>) productTypeRepository.findAll();
        return result;
    }

    public ProductType save(ProductType m) {
        ProductType savedProductType = productTypeRepository.save(m);
        return savedProductType;
    }

    public void delete(ProductType m) {
        productTypeRepository.delete(m);
    }
}
