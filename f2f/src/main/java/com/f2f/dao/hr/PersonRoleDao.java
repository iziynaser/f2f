package com.f2f.dao.hr;

import com.f2f.entity.hr.PersonRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("PersonRoleDao")
public interface PersonRoleDao extends CrudRepository<PersonRole,Long> {

}
