package com.f2f.dao;

import com.f2f.entity.EmployeeTermination;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("EmployeeTerminationDao")
@Repository
public interface EmployeeTerminationDao extends CrudRepository<EmployeeTermination,Long> {
}
