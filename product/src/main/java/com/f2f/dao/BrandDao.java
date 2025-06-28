package com.f2f.dao;

import com.f2f.entity.Category;
import com.f2f.entity.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandDao extends CrudRepository<Brand,Long> {

    List<Brand> getAllByCategoryId(Category category);
}
