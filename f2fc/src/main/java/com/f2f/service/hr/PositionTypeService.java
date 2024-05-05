package com.f2f.service.hr;

import com.f2f.dao.hr.PositionTypeDao;
import com.f2f.entity.hr.PositionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("PositionTypeService")
public class PositionTypeService{

    @Autowired
    PositionTypeDao positionTypeDao;

    public List<PositionType> findAll() {
        return (List<PositionType>) positionTypeDao.findAll();
    }
}
