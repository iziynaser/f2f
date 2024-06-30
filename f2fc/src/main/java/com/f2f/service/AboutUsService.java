package com.f2f.service;

import com.f2f.dao.AboutUsDao;
import com.f2f.domain.EntityNotFoundException;
import com.f2f.entity.AboutUs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AboutUsService {

    @Autowired
    AboutUsDao aboutUsDao;

    public AboutUs getInfo(){
        Optional<AboutUs> entityOptional  = aboutUsDao.findById(Long.valueOf("1"));
        AboutUs aRec = entityOptional.orElseThrow(EntityNotFoundException::new);
        return aRec;
    }

    public AboutUs save(AboutUs aboutUs){
        AboutUs res = aboutUsDao.save(aboutUs);
        return res;
    }

    public AboutUs update(AboutUs aboutUs){
        Optional<AboutUs> entityOptional = aboutUsDao.findById(aboutUs.getId());
        AboutUs aRec = entityOptional.orElseThrow(EntityNotFoundException::new);
        aRec.setAddress(aboutUs.getAddress());
        aRec.setCompanyName(aboutUs.getCompanyName());
        aRec.setDesc(aboutUs.getDesc());
        aRec.setEmail(aboutUs.getEmail());
        aRec.setFax(aboutUs.getFax());
        aRec.setTel(aboutUs.getTel());
        aboutUsDao.save(aRec);
        return aRec;
    }

    public AboutUs updateSocial(AboutUs aboutUs){
        Optional<AboutUs> entityOptional = aboutUsDao.findById(aboutUs.getId());
        AboutUs aRec = entityOptional.orElseThrow(EntityNotFoundException::new);
        aRec.setAparatAddress(aboutUs.getAparatAddress());

        aRec.setInstaAddress(aboutUs.getInstaAddress());
        aRec.setLinkedInAddress(aboutUs.getLinkedInAddress());
        aRec.setTwitterAddress(aboutUs.getTwitterAddress());
        aboutUsDao.save(aRec);
        return aRec;
    }

}
