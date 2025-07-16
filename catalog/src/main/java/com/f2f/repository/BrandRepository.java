package com.f2f.repository;

import com.f2f.entity.Brand;
import com.f2f.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> findAllByCategory(Category category);
    List<Brand> getAllByCategoryId(Category category);

}
