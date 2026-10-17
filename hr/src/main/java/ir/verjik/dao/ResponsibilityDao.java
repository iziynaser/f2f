package ir.verjik.dao;

import ir.verjik.entity.Responsibility;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("ResponsibilityDao")
@Repository
public interface ResponsibilityDao extends CrudRepository<Responsibility,Long> {

}
