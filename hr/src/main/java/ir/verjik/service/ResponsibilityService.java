package ir.verjik.service;

import ir.verjik.dao.ResponsibilityDao;
import ir.verjik.entity.Responsibility;
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
