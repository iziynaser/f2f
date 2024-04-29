package com.f2f.controller;

import com.f2f.entity.AboutUs;
import com.f2f.entity.AboutUsDTO;
import com.f2f.service.AboutUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/f2f/aboutUs")
public class aboutUsController {

    @Autowired
    AboutUsService aboutUsService;

    @GetMapping("/list")
    public AboutUs findAll(){
        AboutUs aboutUs = aboutUsService.getInfo();
        return aboutUs;
    }

    @ResponseBody
    @PostMapping(value = "/save")
    public AboutUs createAboutUs(@RequestBody AboutUsDTO dto){
        AboutUs aboutUs = aboutUsService.getInfo();
        aboutUs.setTel(dto.getTel());
        aboutUs.setFax(dto.getFax());
        aboutUs.setEmail(dto.getEmail());
        aboutUs.setDesc(dto.getDesc());
        aboutUs.setCompanyName(dto.getCompanyName());
        aboutUs.setAddress(dto.getAddress());
        AboutUs result = aboutUsService.save(aboutUs);
        return result;
    }

}
