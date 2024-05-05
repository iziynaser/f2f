package com.f2f.dao.hr;

import com.f2f.entity.hr.EmployeeTermination;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("EmployeeTerminationDao")
public interface EmployeeTerminationDao extends CrudRepository<EmployeeTermination,Long> {
}
