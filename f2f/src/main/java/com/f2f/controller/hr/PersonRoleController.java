package com.f2f.controller.hr;

import com.f2f.entity.hr.PersonRole;
import com.f2f.service.hr.PersonRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("PersonRoleController")
@RequestMapping("/PersonRole")
public class PersonRoleController{

    @Autowired
    PersonRoleService personRoleService;

    @GetMapping("/list")
    public List<PersonRole> getPersonRoleList(){
        List<PersonRole> list = personRoleService.findAll();
        return list;
    }
}
