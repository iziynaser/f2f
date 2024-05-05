package com.f2f.front.dao.product;

import com.f2f.entity.common.KeyValues;
import com.f2f.entity.common.ProductColorDTO;
import com.f2f.entity.product.ProductColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ProductColorDao")
public interface ProductColorDao extends JpaRepository<ProductColor,Long> {

    @Query(nativeQuery = true,value="select pc.color_name as name, pc.color_value as value from Product_Color as pc where pc.product_id = :id")
    List<ProductColorDTO> getListOfProductColors(@Param("id") Long id);

    //@Override
    //List<ProductColor> findAllById(Iterable<Long> iterable);
}
