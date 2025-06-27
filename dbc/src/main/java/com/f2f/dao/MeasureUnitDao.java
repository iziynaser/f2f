package com.f2f.dao;

import com.f2f.entity.MeasureUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("MeasureUnitDao")
@Repository
public interface MeasureUnitDao extends CrudRepository<MeasureUnit,Long>{

}
