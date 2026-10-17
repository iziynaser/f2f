package ir.verjik.service;

import ir.verjik.dao.contact.ContactTypeDao;
import ir.verjik.entity.ContactType;
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
