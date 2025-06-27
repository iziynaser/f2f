package com.f2f.dao;

import com.f2f.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDaoImpl extends JpaRepository<Product,Long> {

}
