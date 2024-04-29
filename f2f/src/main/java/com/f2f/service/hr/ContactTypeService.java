package com.f2f.service.hr;

import com.f2f.dao.contact.ContactTypeDao;
import com.f2f.entity.hr.ContactType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ContactTypeService")
public class ContactTypeService{

    @Autowired
    ContactTypeDao contactTypeDao;

    public List<ContactType> findAll() {
        return (List<ContactType>) contactTypeDao.findAll();
    }
}
