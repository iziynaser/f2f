package com.f2f.service;

import com.f2f.dao.OstanDao;
import com.f2f.dao.ShahrDao;
import com.f2f.entity.Ostan;
import com.f2f.entity.Shahr;
<<<<<<< Updated upstream:src/main/java/com/f2f/service/ShahrService.java
import com.revengemission.sso.oauth2.server.domain.EntityNotFoundException;
import org.apache.commons.codec.EncoderException;
=======
import com.f2f.domain.EntityNotFoundException;
>>>>>>> Stashed changes:f2f/src/main/java/com/f2f/service/ShahrService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ShahrService {

    @Autowired
    ShahrDao shahrDao;

    @Autowired
    OstanDao ostanDao;

    public List<Shahr> getInfo(String ostanId){

        Optional<Ostan> optionalOstan =ostanDao.findById(Long.valueOf(ostanId));
        Ostan ostan = optionalOstan.orElseThrow(EntityNotFoundException::new);

        List<Shahr> shahrList = shahrDao.getAllByOstan(ostan);
        return shahrList;
    }

    public Shahr getOne(Long id){
        Shahr shahr = shahrDao.getOne(id);
        return shahr;
    }
}
