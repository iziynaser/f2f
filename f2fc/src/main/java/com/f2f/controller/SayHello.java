package com.f2f.controller;

import com.f2f.entity.AboutUs;
import com.f2f.entity.AboutUsDTO;
import com.f2f.service.AboutUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/f2f")
public class SayHello {



    @GetMapping("/hi")
    public String findAll() {
        return "Hello f2f";
    }



}
