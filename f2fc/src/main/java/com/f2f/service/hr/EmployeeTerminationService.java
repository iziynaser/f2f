package com.f2f.service.hr;

import com.f2f.dao.hr.EmployeeTerminationDao;
import com.f2f.entity.hr.EmployeeTermination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("EmployeeTerminationService")
public class EmployeeTerminationService{

    @Autowired
    EmployeeTerminationDao employeeTerminationDao;

    public List<EmployeeTermination> findAll() {
        return (List<EmployeeTermination>) employeeTerminationDao.findAll();
    }
}
