package com.f2f.controller.hr;

import com.f2f.entity.hr.SkillType;
import com.f2f.service.hr.SkillTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("SkillTypeController")
@RequestMapping("/f2f/skillType")
public class SkillTypeController {

    @Autowired
    SkillTypeService skillTypeService;

    @GetMapping("/list")
    public List<SkillType> getSkillTypes(){
        List<SkillType> list =  skillTypeService.findAll();
        return list;
    }
}
