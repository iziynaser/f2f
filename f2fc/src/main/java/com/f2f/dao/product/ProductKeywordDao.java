package com.f2f.dao.product;

import com.f2f.entity.product.Product;
import com.f2f.entity.product.ProductKeyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ProductKeywordDao")
public interface ProductKeywordDao extends JpaRepository<ProductKeyword,Long> {

    List<ProductKeyword> findAllByProduct(Product product);
}
