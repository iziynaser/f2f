package com.f2f.controller.account;

import com.f2f.entity.acc.Currency;
import com.f2f.service.account.CurrencyService;
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
