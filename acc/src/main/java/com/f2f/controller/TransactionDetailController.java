package com.f2f.controller;

import com.f2f.entity.TransactionDetail;
import com.f2f.service.TransactionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("TransactionDetailController")
@RequestMapping("/TransactionDetail")
public class TransactionDetailController {

    @Autowired
    TransactionDetailService transactionDetailService;

    @GetMapping("/list")
    public List<TransactionDetail> getTransactionDetailList(){
        return transactionDetailService.findAll();
    }
}
