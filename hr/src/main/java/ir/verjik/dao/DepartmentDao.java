package ir.verjik.dao;

import ir.verjik.entity.DepartmentB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("DepartmentDao")
@Repository
public interface DepartmentDao extends CrudRepository<DepartmentB,Long> {

}
