package com.f2f.dao;

import com.f2f.entity.ProductComments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductCommentsDao extends CrudRepository<ProductComments,Long> {

    @Query("select count(*) from ProductComments pc where pc.product.id = :id")
    Integer getCountOfCommentsOnProduct(@Param("id") Long id);
}
