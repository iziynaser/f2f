package com.f2f.dao.product;

import com.f2f.entity.shopping.Pricing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PricingDao extends CrudRepository<Pricing,Long> {

    //int getCountOfCommentsOnProduct(@Param("id") Long id);

    @Query("select count(*) from Pricing pr where pr.product.id = :id")
    int getCountOfOtherSellersOnProduct(@Param("id") Long id);
}
