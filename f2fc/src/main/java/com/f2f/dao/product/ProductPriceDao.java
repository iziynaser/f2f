package com.f2f.dao.product;

import com.f2f.entity.product.Product;
import com.f2f.entity.product.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ProductPriceDao")
public interface ProductPriceDao extends JpaRepository<ProductPrice,Long> {

    //@Query("select pps.* from ProductPrices as pps where pps.product = :product")
    //List<ProductPrice> getProductPricesList(@Param("product") Product product);

    @Query("select pps from ProductPrice as pps where pps.product = :product")
    List<ProductPrice> getProductPricesList(@Param("product") Product product);

    List<ProductPrice> findAllByProduct(Product product);

}
