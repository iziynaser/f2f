package ir.verjik.service;

import ir.verjik.dao.PositionDao;
import ir.verjik.entity.Position;
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
