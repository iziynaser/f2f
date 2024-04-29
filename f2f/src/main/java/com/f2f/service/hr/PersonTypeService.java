package com.f2f.service.hr;

import com.f2f.dao.personType.PersonTypeDao;
import com.f2f.entity.hr.PersonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("PersonTypeService")
public class PersonTypeService{

    @Autowired
    PersonTypeDao personTypeDao;

    public List<PersonType> findAll() {
        return (List<PersonType>) personTypeDao.findAll();
    }
}
