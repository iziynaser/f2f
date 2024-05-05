package com.f2f.controller.account;

import com.f2f.entity.acc.AccountingTransaction;
import com.f2f.service.account.AccountingTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("AccountingTransactionController")
@RequestMapping("/AccountingTransaction")
public class AccountingTransactionController {

    @Autowired
    AccountingTransactionService accountingTransactionService;

    @GetMapping("/list")
    public List<AccountingTransaction> getAccountingTransactionList(){
        return accountingTransactionService.findAll();
    }


}
