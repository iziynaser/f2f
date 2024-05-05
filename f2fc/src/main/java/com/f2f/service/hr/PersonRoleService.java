package com.f2f.service.hr;

import com.f2f.dao.hr.PersonRoleDao;
import com.f2f.entity.hr.PersonRole;
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
