package com.f2f.dao.hr;

import com.f2f.entity.hr.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("SkillDao")
public interface SkillDao extends CrudRepository<Skill,Long> {

}
