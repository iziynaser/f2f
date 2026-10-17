package ir.verjik.service;

import ir.verjik.dao.EmploymentDao;
import ir.verjik.entity.Employment;
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
