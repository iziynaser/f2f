package com.f2f.dao.person;

import com.f2f.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("PersonDao")
@Repository
public interface PersonDao extends CrudRepository<PersonEntity,Long> {

}
