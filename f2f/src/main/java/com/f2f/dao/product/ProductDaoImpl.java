package com.f2f.dao.product;

import com.f2f.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDaoImpl extends JpaRepository<Product,Long> {

}
