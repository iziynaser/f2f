package com.f2f.dao.hr;

import com.f2f.entity.hr.Responsibility;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("ResponsibilityDao")
public interface ResponsibilityDao extends CrudRepository<Responsibility,Long> {

}
