package com.f2f.dao.hr;

import com.f2f.entity.hr.DepartmentB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("DepartmentDao")
public interface DepartmentDao extends CrudRepository<DepartmentB,Long> {

}
