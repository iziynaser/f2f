package ir.verjik.dao;

import ir.verjik.entity.Resume;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("ResumeDao")
@Repository
public interface ResumeDao extends CrudRepository<Resume,Long> {

}
