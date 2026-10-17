package ir.verjik.service;

import ir.verjik.dao.SkillTypeDao;
import ir.verjik.entity.SkillType;
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
