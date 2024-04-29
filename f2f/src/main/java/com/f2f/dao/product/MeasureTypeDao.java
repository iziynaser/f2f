package com.f2f.dao.product;

import com.f2f.entity.acc.MeasureUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("MeasureTypeDao")
public interface MeasureTypeDao extends CrudRepository<MeasureUnit,Long> {

}
