package com.f2f.service;

import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.entity.Ostan;
import com.f2f.entity.Shahr;
import com.f2f.repository.OstanRepository;
import com.f2f.repository.ShahrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShahrServiceImpl implements ShahrService {

    @Autowired
    private ShahrRepository shahrRepository;

    @Autowired
    private OstanRepository ostanRepository;

    @Override
    public List<Shahr> getInfo(Long ostanId) {
        Ostan ostan = ostanRepository.findById(ostanId)
                .orElseThrow(() -> new EntityNotFoundException("Ostan not found with id: " + ostanId));

        return shahrRepository.getAllByOstan(ostan);
    }

    public Shahr getOne(Long id) {
        return shahrRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shahr not found with id: " + id));
    }
}
