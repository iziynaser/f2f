package com.f2f.service.hr;

import com.f2f.dao.person.PersonDao;
import com.f2f.entity.common.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("PersonService")
public class PersonService {

    @Autowired
    PersonDao dao;

    public List<Person> findAll(){
        List<Person> r = (List<Person>)dao.findAll();
        return r;
    }

    public Person save(Person p) {
        return dao.save(p);
    }

    public Optional findById(Long id) {
        return dao.findById(id);
    }

    public void delete(Person b,int id) {
        dao.delete(b);
    }

}
