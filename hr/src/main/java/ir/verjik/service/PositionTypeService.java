package ir.verjik.service;

import ir.verjik.dao.PositionTypeDao;
import ir.verjik.entity.PositionType;
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
