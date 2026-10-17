package ir.verjik.service;

import ir.verjik.dao.HolidayDao;
import ir.verjik.entity.Holiday;
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
