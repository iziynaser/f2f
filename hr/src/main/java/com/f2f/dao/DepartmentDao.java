package com.f2f.dao;

import com.f2f.entity.DepartmentB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("DepartmentDao")
@Repository
public interface DepartmentDao extends CrudRepository<DepartmentB,Long> {

}
