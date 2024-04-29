package com.f2f.controller.account;

import com.f2f.entity.acc.Account;
import com.f2f.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("AccountController")
@RequestMapping("/Account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/list")
    public List<Account> getAccountList(){
        List<Account> list = accountService.findAll();
        return list;
    }
}
