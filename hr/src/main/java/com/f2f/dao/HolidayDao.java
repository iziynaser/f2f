package com.f2f.dao;

import com.f2f.entity.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("HolidayDao")
@Repository
public interface HolidayDao extends CrudRepository<Holiday,Long> {

}
