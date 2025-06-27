package com.f2f.controller;

import com.f2f.entity.AccountGroup;
import com.f2f.service.AccountGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("AccountGroupController")
@RequestMapping("/AccountGroup")
public class AccountGroupController {

    @Autowired
    AccountGroupService accountGroupService;

    @GetMapping("/list")
    public List<AccountGroup> getAccountGroupList(){
        List<AccountGroup> list = accountGroupService.findAll();
        return list;
    }
}
