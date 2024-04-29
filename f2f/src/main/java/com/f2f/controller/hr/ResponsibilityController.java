package com.f2f.controller.hr;

import com.f2f.entity.hr.Responsibility;
import com.f2f.service.hr.ResponsibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("ResponsibilityController")
@RequestMapping("/Responsibility")
public class ResponsibilityController{

    @Autowired
    ResponsibilityService responsibilityService;

    @GetMapping("/list")
    public List<Responsibility> getResponsibilityList(){
        List<Responsibility> list = responsibilityService.findAll();
        return list ;
    }
}
