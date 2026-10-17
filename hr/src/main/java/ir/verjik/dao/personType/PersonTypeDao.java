package ir.verjik.dao.personType;

import ir.verjik.entity.PersonType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("PersonTypeDao")
@Repository
public interface PersonTypeDao extends CrudRepository<PersonType,Long> {


}
