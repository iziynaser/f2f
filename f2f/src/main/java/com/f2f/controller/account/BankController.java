package com.f2f.controller.account;

import com.f2f.entity.acc.Bank;
import com.f2f.service.account.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("BankController")
@RequestMapping("/Bank")
public class BankController {

    @Autowired
    BankService bankService;

    @GetMapping("/list")
    public List<Bank> getBankList(){
        return bankService.findAll();
    }

}
