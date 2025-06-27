package com.f2f.service;

import com.f2f.dao.PersonDao;
import com.f2f.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("PersonService")
public class PersonService {

    @Autowired
    PersonDao dao;

    public List<PersonEntity> findAll(){
        List<PersonEntity> r = (List<PersonEntity>)dao.findAll();
        return r;
    }

    public PersonEntity save(PersonEntity p) {
        return dao.save(p);
    }

    public Optional findById(Long id) {
        return dao.findById(id);
    }

//    public void delete(PersonDTO b, int id) {
//        dao.delete(b);
//    }

}
