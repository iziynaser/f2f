package com.f2f.dao.product;

import com.f2f.entity.product.ProductType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("ProductTypeDao")
public interface ProductTypeDao extends CrudRepository<ProductType,Long> {

}
