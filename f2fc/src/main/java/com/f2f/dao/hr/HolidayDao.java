package com.f2f.dao.hr;

import com.f2f.entity.hr.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("HolidayDao")
public interface HolidayDao extends CrudRepository<Holiday,Long> {

}
