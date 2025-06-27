package com.f2f.dao;

import com.f2f.entity.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("PositionDao")
@Repository
public interface PositionDao extends CrudRepository<Position,Long> {

}
