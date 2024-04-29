package com.f2f.controller.account;

import com.f2f.entity.acc.AccountingPeriod;
import com.f2f.service.account.AccountingPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("AccountingPeriodController")
@RequestMapping("/AccountingPeriod")
public class AccountingPeriodController {

    @Autowired
    AccountingPeriodService accountingPeriodService;

    @GetMapping("/list")
    public List<AccountingPeriod> getAccountingPeriodList(){
        return accountingPeriodService.findAll();
    }
}
