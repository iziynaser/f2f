package com.f2f.dao.hr;

import com.f2f.entity.hr.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("PositionDao")
public interface PositionDao extends CrudRepository<Position,Long> {

}
