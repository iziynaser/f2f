package com.f2f.service;

import com.f2f.dao.HolidayDao;
import com.f2f.entity.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("HolidayService")
public class HolidayService{

    @Autowired
    HolidayDao holidayDao;

    public List<Holiday> findAll() {
        return (List<Holiday>) holidayDao.findAll();
    }
}
