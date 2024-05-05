package com.f2f.dao.hr;

import com.f2f.entity.hr.PositionType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("PositionTypeDao")
public interface PositionTypeDao extends CrudRepository<PositionType,Long> {

}
