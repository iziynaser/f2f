package com.f2f.service.product;

import com.f2f.dao.product.MeasureTypeDao;
import com.f2f.entity.acc.MeasureUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MeasureTypeService {

    @Autowired
    MeasureTypeDao mesMeasureTypeDao;

    public List<MeasureUnit> findAll(){
        List<MeasureUnit> measureUnits = (List<MeasureUnit>) mesMeasureTypeDao.findAll();
        return measureUnits;
    }

    public MeasureUnit save(MeasureUnit m) {
        MeasureUnit savedUnit = mesMeasureTypeDao.save(m);
        return savedUnit;
    }

    public void delete(MeasureUnit m) {
        mesMeasureTypeDao.delete(m);
    }
}
