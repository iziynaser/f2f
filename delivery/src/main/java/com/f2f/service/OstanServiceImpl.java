package com.f2f.service;

import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.entity.Ostan;
import com.f2f.repository.OstanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OstanServiceImpl implements OstanService {

    @Autowired
    private OstanRepository ostanDao;

    @Override
    public List<Ostan> getInfo() {
        return ostanDao.findAll();
    }

    public Ostan getOne(Long id) {
        return ostanDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ostan not found with id: " + id));
    }
}
