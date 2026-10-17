package ir.verjik.dao;

import ir.verjik.entity.SkillType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("SkillTypeDao")
@Repository
public interface SkillTypeDao extends CrudRepository<SkillType,Long> {

}
