package com.f2f.controller.account;

import com.f2f.entity.acc.TransactionType;
import com.f2f.service.account.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("TransactionTypeController")
@RequestMapping("/TransactionType")
public class TransactionTypeController {

    @Autowired
    TransactionTypeService transactionTypeService;

    @GetMapping("/list")
    public List<TransactionType> getTransactionTypeList(){
        return transactionTypeService.findAll();
    }
}
