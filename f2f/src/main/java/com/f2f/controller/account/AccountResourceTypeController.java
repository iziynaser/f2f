package com.f2f.controller.account;

import com.f2f.entity.acc.AccountResourceType;
import com.f2f.service.account.AccountResourceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("AccountResourceTypeController")
@RequestMapping("/AccountResource")
public class AccountResourceTypeController {

    @Autowired
    AccountResourceTypeService accountResourceTypeService;

    @GetMapping("/list")
    public List<AccountResourceType> getAccountResourceTypeList(){
        return accountResourceTypeService.findAll();
    }

}
