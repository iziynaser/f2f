package com.f2f.dao.person;

import com.f2f.entity.common.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("PersonDao")
public interface PersonDao extends CrudRepository<Person,Long> {

}
