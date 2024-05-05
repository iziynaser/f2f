package com.f2f.dao.personType;

import com.f2f.entity.hr.PersonType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("PersonTypeDao")
public interface PersonTypeDao extends CrudRepository<PersonType,Long> {


}
