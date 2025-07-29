package com.f2f.service;

import com.f2f.entity.MeasureUnit;
import com.f2f.repository.MeasureTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MeasureTypeService {

    @Autowired
    MeasureTypeRepository mesMeasureTypeRepository;

    public List<MeasureUnit> findAll(){
        List<MeasureUnit> measureUnits = (List<MeasureUnit>) mesMeasureTypeRepository.findAll();
        return measureUnits;
    }

    public MeasureUnit save(MeasureUnit m) {
        MeasureUnit savedUnit = mesMeasureTypeRepository.save(m);
        return savedUnit;
    }

    public void delete(MeasureUnit m) {
        mesMeasureTypeRepository.delete(m);
    }
}
