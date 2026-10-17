package ir.verjik.service;

import ir.verjik.dao.PersonRoleDao;
import ir.verjik.entity.PersonRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("PersonRoleService")
public class PersonRoleService{

    @Autowired
    PersonRoleDao personRoleDao;

    public List<PersonRole> findAll() {
        return (List<PersonRole>) personRoleDao.findAll();
    }
}
