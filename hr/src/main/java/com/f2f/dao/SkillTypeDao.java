package com.f2f.dao;

import com.f2f.entity.SkillType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("SkillTypeDao")
@Repository
public interface SkillTypeDao extends CrudRepository<SkillType,Long> {

}
