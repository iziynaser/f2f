package ir.verjik.service;

import ir.verjik.dao.EmployeeTerminationDao;
import ir.verjik.entity.EmployeeTermination;
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
