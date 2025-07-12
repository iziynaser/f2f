package com.f2f.service;

import com.f2f.dao.BrandDao;
import com.f2f.dao.ProductItemRepository;
import com.f2f.entity.Category;
import com.f2f.entity.Brand;
import com.f2f.entity.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("BrandService")
public class BrandService {

    @Autowired
    BrandDao dao;

    ProductItemRepository productItemRepository;

    public List<Brand> findAll(){
        return (List<Brand>) dao.findAll();
    }

    public Brand save(Brand brand) {
        return dao.save(brand);
    }

    public Optional findById(Long id) {
        return dao.findById(id);
    }

    public void delete(Brand b) {
        dao.delete(b);
    }

    public List<Brand> getAllBrandsByCategoryId(Category category){
        List<Brand> brands = dao.getAllByCategoryId(category);
        return brands;
    }

    /*
    بازگرداندن برند کالا با استفاده از ای دی کالا
     */
    public String getBrandNameByProductItemId(Long productItemId){
        ProductItem productItem = productItemRepository.findById(productItemId)
                .orElseThrow(()-> new RuntimeException("Product Item Not Found"));

        Brand brand = productItem.getBrand();
        if(brand != null){
            return brand.getName();
        }else {
            return "unknown";
        }

    }
}
