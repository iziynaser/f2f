package com.f2f.controller;

import com.f2f.entity.Cash;
import com.f2f.service.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("CashController")
@RequestMapping("/Cash")
public class CashController {

    @Autowired
    CashService cashService;

    @GetMapping("/list")
    public List<Cash> getCashList(){
        return cashService.findAll();
    }

}
