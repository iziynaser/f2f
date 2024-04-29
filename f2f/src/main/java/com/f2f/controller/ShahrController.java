package com.f2f.controller;

import com.f2f.entity.Shahr;
import com.f2f.service.ShahrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/f2f/shahr")
public class ShahrController {

    @Autowired
    ShahrService shahrService;

    @GetMapping("/list")
    public List<Shahr> findAll(@RequestParam(value = "id") String ostanId){
        List<Shahr> result = shahrService.getInfo(ostanId);
        return result;
    }

}
