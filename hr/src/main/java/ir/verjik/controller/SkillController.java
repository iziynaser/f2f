package ir.verjik.controller;

import ir.verjik.entity.Skill;
import ir.verjik.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("SkillController")
@RequestMapping("/skill")
public class SkillController{

    @Autowired
    SkillService skillService;

    @GetMapping("/list")
    public List<Skill> getSkillList(){
        List<Skill> list= skillService.findAll();
        return list;
    }
}
