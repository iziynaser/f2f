package ir.verjik.controller;

import ir.verjik.entity.Contact;
import ir.verjik.service.ContactService;
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
