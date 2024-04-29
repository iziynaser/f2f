package com.f2f.service;

import com.f2f.dao.OstanDao;
import com.f2f.entity.Ostan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OstanService {

    @Autowired
    OstanDao ostanDao;

    public List<Ostan> getInfo(){
        List<Ostan> result = ostanDao.findAll();
        return result;
    }

    public Ostan getOne(Long id){
        Ostan ostan = ostanDao.getOne(id);
        return ostan;
    }
}
