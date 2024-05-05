package com.f2f.service.account;

import com.f2f.exceptions.F2fNotFoundException;
import com.f2f.dao.acc.MeasureUnitDao;
import com.f2f.entity.acc.MeasureUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("MeasureUnitService")
public class MeasureUnitService {

    @Autowired
    MeasureUnitDao measureUnitDao;

    public List<MeasureUnit> findAll(){
        return (List<MeasureUnit>) measureUnitDao.findAll();
    }

    public MeasureUnit findById(Long id)  throws F2fNotFoundException {
        Optional<MeasureUnit> measureUnitOptional = measureUnitDao.findById(id);
        MeasureUnit measureUnit = measureUnitOptional.orElseThrow(F2fNotFoundException::new);
        return measureUnit;
    }

}
