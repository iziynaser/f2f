package com.f2f.dao.product;

import com.f2f.entity.product.ProductComments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductCommentsDao extends CrudRepository<ProductComments,Long> {

    @Query("select count(*) from ProductComments pc where pc.product.id = :id")
    int getCountOfCommentsOnProduct(@Param("id") Long id);
}
