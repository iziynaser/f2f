package ir.verjik.dao;

import ir.verjik.entity.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("SkillDao")
@Repository
public interface SkillDao extends CrudRepository<Skill,Long> {

}
