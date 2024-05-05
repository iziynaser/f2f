package com.f2f.service.hr;

import com.f2f.dao.hr.ResponsibilityDao;
import com.f2f.entity.hr.Responsibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ResponsibilityService")
public class ResponsibilityService{

    @Autowired
    ResponsibilityDao responsibilityDao;

    public List<Responsibility> findAll() {
        return (List<Responsibility>) responsibilityDao.findAll();
    }
}
