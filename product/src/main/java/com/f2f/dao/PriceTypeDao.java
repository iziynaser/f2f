package com.f2f.dao;

import com.f2f.entity.PriceType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("PriceTypeDao")
@Repository
public interface PriceTypeDao extends CrudRepository<PriceType,Long> {

}
