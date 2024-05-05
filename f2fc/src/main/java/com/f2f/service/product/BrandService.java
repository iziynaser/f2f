package com.f2f.service.product;

import com.f2f.dao.product.BrandDao;
import com.f2f.entity.common.Category;
import com.f2f.entity.product.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("BrandService")
public class BrandService {

    @Autowired
    BrandDao dao;

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
}
