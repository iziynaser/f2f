package com.f2f.controller.hr;

import com.f2f.entity.hr.Employment;
import com.f2f.service.hr.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("EmploymentController")
@RequestMapping("/Employment")
public class EmploymentController{

    @Autowired
    EmploymentService employmentService;

    @GetMapping("/list")
    public List<Employment> getEmploymentList(){
        List<Employment> list = employmentService.findAll();
        return list;
    }

}
