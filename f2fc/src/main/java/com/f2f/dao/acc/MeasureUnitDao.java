package com.f2f.dao.acc;

import com.f2f.entity.acc.MeasureUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("MeasureUnitDao")
public interface MeasureUnitDao extends CrudRepository<MeasureUnit,Long>{

}
