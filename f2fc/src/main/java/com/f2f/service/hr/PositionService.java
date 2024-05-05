package com.f2f.service.hr;

import com.f2f.dao.hr.PositionDao;
import com.f2f.entity.hr.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("PositionService")
public class PositionService{

    @Autowired
    PositionDao positionDao;

    public List<Position> findAll() {
        return (List<Position>) positionDao.findAll();
    }
}
