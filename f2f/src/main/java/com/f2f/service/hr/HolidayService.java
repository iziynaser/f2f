package com.f2f.service.hr;

import com.f2f.dao.hr.HolidayDao;
import com.f2f.entity.hr.Holiday;
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
