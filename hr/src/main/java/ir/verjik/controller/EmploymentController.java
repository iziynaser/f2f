package ir.verjik.controller;

import ir.verjik.entity.Employment;
import ir.verjik.service.EmploymentService;
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
