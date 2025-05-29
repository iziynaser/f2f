package com.f2f.dao;


import com.f2f.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryId(Long categoryId);

    // ارزان‌ترین کالاها (قیمت صعودی)
//    List<Product> findAllByOrderByPriceAsc();
//
//    // گران‌ترین کالاها (قیمت نزولی)
//    List<Product> findAllByOrderByPriceDesc();
//
//    // پرفروش‌ترین کالاها (تعداد فروش نزولی)
//    List<Product> findAllByOrderBySalesCountDesc();

    @Query("Select p from Product as p join Catalog as c on p.categoryId = c.id where c.id = :catalogId")
    List<Product> findByCatalogId(@Param("catalogId") Long catalogId);
}
