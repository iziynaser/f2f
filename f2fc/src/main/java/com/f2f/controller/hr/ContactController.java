package com.f2f.controller.hr;

import com.f2f.entity.hr.Contact;
import com.f2f.service.hr.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("ContactController")
@RequestMapping("/Contact")
public class ContactController{

    @Autowired
    ContactService contactService;

    @GetMapping("/list")
    public List<Contact> getContactList(){
        List<Contact> list = contactService.findAll();
        return list;
    }
}
