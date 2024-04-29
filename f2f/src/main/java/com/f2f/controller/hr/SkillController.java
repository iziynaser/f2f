package com.f2f.controller.hr;

import com.f2f.entity.hr.Skill;
import com.f2f.service.hr.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("SkillController")
@RequestMapping("/f2f/skill")
public class SkillController{

    @Autowired
    SkillService skillService;

    @GetMapping("/list")
    public List<Skill> getSkillList(){
        List<Skill> list= skillService.findAll();
        return list;
    }
}
