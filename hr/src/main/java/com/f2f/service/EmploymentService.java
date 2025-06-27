package com.f2f.service;

import com.f2f.dao.EmploymentDao;
import com.f2f.entity.Employment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("EmploymentService")
public class EmploymentService{

    @Autowired
    EmploymentDao employmentDao;

    public List<Employment> findAll() {
        return (List<Employment>) employmentDao.findAll();
    }
}
