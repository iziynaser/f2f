package com.f2f.dao;

import com.f2f.entity.ProductType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("ProductTypeDao")
@Repository
public interface ProductTypeDao extends CrudRepository<ProductType,Long> {

}
