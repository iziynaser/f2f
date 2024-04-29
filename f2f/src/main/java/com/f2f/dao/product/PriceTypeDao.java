package com.f2f.dao.product;

import com.f2f.entity.common.PriceType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("PriceTypeDao")
public interface PriceTypeDao extends CrudRepository<PriceType,Long> {

}
