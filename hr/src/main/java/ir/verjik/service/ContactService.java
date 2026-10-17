package ir.verjik.service;

import ir.verjik.dao.ContactDao;
import ir.verjik.entity.Contact;
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
