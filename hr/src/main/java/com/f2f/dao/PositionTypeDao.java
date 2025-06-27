package com.f2f.dao;

import com.f2f.entity.PositionType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("PositionTypeDao")
@Repository
public interface PositionTypeDao extends CrudRepository<PositionType,Long> {

}
