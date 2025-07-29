package com.f2f.repository;

import com.f2f.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherSellersRepository extends JpaRepository<Product,Long> {
}
