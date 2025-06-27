package com.f2f.controller;

import com.f2f.entity.AccountType;
import com.f2f.service.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("AccountTypeController")
@RequestMapping("/AccountType")
public class AccountTypeController {

    @Autowired
    AccountTypeService accountTypeService;

    @GetMapping("/list")
    public List<AccountType> getAccountTypeList() {
        return accountTypeService.findAll();

}

}
