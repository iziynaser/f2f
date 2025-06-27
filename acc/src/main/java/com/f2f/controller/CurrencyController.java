package com.f2f.controller;

import com.f2f.entity.Currency;
import com.f2f.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("CurrencyController")
@RequestMapping("/Currency")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @GetMapping("/list")
    public List<Currency> getCurrencyList(){
       return currencyService.findAll();
    }
}
