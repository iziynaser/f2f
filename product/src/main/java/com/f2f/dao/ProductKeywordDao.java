package com.f2f.dao;

import com.f2f.entity.Product;
import com.f2f.entity.ProductKeyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository("ProductKeywordDao")
@Repository
public interface ProductKeywordDao extends JpaRepository<ProductKeyword,Long> {

    List<ProductKeyword> findAllByProducts(Product product);
}
