package com.f2f.controller.hr;

import com.f2f.entity.hr.PersonType;
import com.f2f.service.hr.PersonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("PersonTypeController")
@RequestMapping("/PersonType")
public class PersonTypeController{

    @Autowired
    PersonTypeService personTypeService;

    @GetMapping("/list")
    public List<PersonType> getPersonTypeList(){
        List<PersonType> list = personTypeService.findAll();
        return list;
    }
}
