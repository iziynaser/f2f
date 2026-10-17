package ir.verjik.dao;

import ir.verjik.entity.Employment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("EmploymentDao")
@Repository
public interface EmploymentDao extends CrudRepository<Employment,Long> {

}
