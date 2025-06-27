package com.f2f.controller;

import com.f2f.entity.TransactionStatus;
import com.f2f.service.TransactionStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("TransactionStatusController")
@RequestMapping("/TransactionStatus")
public class TransactionStatusController {

    @Autowired
    TransactionStatusService transactionStatusService;

    @GetMapping("/list")
    public List<TransactionStatus> getTransactionStatusList(){
        return transactionStatusService.findAll();
    }
}
