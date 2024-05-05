package com.f2f.controller.hr;

import com.f2f.entity.hr.ContactType;
import com.f2f.service.hr.ContactTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("ContactTypeController")
@RequestMapping("/ContactType")
public class ContactTypeController{

    @Autowired
    ContactTypeService contactTypeService ;

    @GetMapping("/list")
    public List<ContactType> getContactTypeList(){
        List<ContactType> list = contactTypeService.findAll();
        return list ;
    }
}
