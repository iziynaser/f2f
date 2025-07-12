package com.f2f.service;

import com.f2f.repository.PriceTypeDao;
import com.f2f.entity.PriceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PriceTypeService {

    @Autowired
    PriceTypeDao priceTypeDao;

    public List<PriceType> findAll(){
        List<PriceType> priceType = (List<PriceType>) priceTypeDao.findAll();
        return priceType;
    }

    public PriceType save(PriceType p) {
        PriceType r = priceTypeDao.save(p);
        return r;
    }
}
