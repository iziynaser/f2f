package com.f2f.dao;

import com.f2f.entity.Employment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("EmploymentDao")
@Repository
public interface EmploymentDao extends CrudRepository<Employment,Long> {

}
