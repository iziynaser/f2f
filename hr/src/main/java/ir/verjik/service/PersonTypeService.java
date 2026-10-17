package ir.verjik.service;

import ir.verjik.dao.personType.PersonTypeDao;
import ir.verjik.entity.PersonType;
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
