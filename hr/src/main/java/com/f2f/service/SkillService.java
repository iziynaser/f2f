package com.f2f.service;

import com.f2f.dao.SkillDao;
import com.f2f.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("SkillService")
public class SkillService{

    @Autowired
    SkillDao skillDao;

    public List<Skill> findAll() {
        return (List<Skill>) skillDao.findAll();
    }
}
