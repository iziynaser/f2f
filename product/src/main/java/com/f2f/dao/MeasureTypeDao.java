package com.f2f.dao;

import com.f2f.entity.MeasureUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("MeasureTypeDao")
@Repository
public interface MeasureTypeDao extends CrudRepository<MeasureUnit,Long> {

}
