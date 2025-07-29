package com.f2f.repository;

import com.f2f.entity.ProductComments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductCommentsRepository extends CrudRepository<ProductComments,Long> {

    @Query("select count(*) from ProductComments pc where pc.productId = :id")
    Integer getCountOfCommentsOnProduct(@Param("id") Long id);
}
