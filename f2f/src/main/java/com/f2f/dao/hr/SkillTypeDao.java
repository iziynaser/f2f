package com.f2f.dao.hr;

import com.f2f.entity.hr.SkillType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("SkillTypeDao")
public interface SkillTypeDao extends CrudRepository<SkillType,Long> {

}
