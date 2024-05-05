package com.f2f.service.hr;

import com.f2f.dao.hr.SkillTypeDao;
import com.f2f.entity.hr.SkillType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("SkillTypeService")
public class SkillTypeService {

    @Autowired
    SkillTypeDao skillTypeDao ;

    public List<SkillType> findAll(){
        return (List<SkillType>) skillTypeDao.findAll();
    }

}
