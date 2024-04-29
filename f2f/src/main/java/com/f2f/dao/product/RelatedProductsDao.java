package com.f2f.dao.product;

import com.f2f.entity.product.Product;
import com.f2f.entity.product.RelatedProductsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RelatedProductsDao")
public interface RelatedProductsDao extends JpaRepository<Product,Long> {

    //List<RelatedProductsDTO> listOfRelatedProducts(Long productId);
}
