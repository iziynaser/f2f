package ir.verjik.dao;

import ir.verjik.entity.PersonRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("PersonRoleDao")
@Repository
public interface PersonRoleDao extends CrudRepository<PersonRole,Long> {

}
