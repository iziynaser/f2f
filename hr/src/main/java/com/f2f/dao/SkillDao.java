package com.f2f.dao;

import com.f2f.entity.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("SkillDao")
@Repository
public interface SkillDao extends CrudRepository<Skill,Long> {

}
