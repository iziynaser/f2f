package com.f2f.dao;

import com.f2f.entity.Responsibility;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("ResponsibilityDao")
@Repository
public interface ResponsibilityDao extends CrudRepository<Responsibility,Long> {

}
