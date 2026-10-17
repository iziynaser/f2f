package ir.verjik.service;

import ir.verjik.dao.SkillDao;
import ir.verjik.entity.Skill;
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
