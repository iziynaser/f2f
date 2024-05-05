package com.f2f.dao.product;

import com.f2f.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("OtherSellersDao")
public interface OtherSellersDao  extends JpaRepository<Product,Long> {
}
