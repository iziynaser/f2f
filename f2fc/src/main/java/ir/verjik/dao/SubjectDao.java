package ir.verjik.dao;

import ir.verjik.entity.common.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("SubjectDao")
@Repository
public interface SubjectDao extends CrudRepository<Subject,Long>{

}
