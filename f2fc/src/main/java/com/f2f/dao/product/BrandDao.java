package com.f2f.dao.product;

import com.f2f.entity.common.Category;
import com.f2f.entity.product.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("BrandDao")
public interface BrandDao extends CrudRepository<Brand,Long> {

    List<Brand> getAllByCategoryId(Category category);
}
