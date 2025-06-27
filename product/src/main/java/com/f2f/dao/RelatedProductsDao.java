package com.f2f.dao;

import com.f2f.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository("RelatedProductsDao")
@Repository
public interface RelatedProductsDao extends JpaRepository<Product,Long> {

    //List<RelatedProductsDTO> listOfRelatedProducts(Long productId);
}
