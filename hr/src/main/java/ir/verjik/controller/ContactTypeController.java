package ir.verjik.controller;

import ir.verjik.entity.ContactType;
import ir.verjik.service.ContactTypeService;
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
