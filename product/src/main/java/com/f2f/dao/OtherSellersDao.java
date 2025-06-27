package com.f2f.dao;

import com.f2f.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository("OtherSellersDao")
@Repository
public interface OtherSellersDao  extends JpaRepository<Product,Long> {
}
