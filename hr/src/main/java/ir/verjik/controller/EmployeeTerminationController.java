package ir.verjik.controller;

import ir.verjik.entity.EmployeeTermination;
import ir.verjik.service.EmployeeTerminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("EmployeeTerminationController")
@RequestMapping("/EmployeeTermination")
public class EmployeeTerminationController{

    @Autowired
    EmployeeTerminationService employeeTerminationService ;

    @GetMapping("/list")
    public List<EmployeeTermination> getEmployeeTerminationList(){
        List<EmployeeTermination> list = employeeTerminationService.findAll();
        return list;
    }
}

