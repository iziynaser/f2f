package com.f2f.service.hr;

import com.f2f.dao.ContactDao;
import com.f2f.entity.hr.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ContactService")
public class ContactService{

    @Autowired
    ContactDao contactDao;

    public List<Contact> findAll() {
        return (List<Contact>) contactDao.findAll();
    }
}
