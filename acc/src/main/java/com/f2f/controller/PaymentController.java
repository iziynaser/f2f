package com.f2f.controller;

import com.f2f.entity.Payment;
import com.f2f.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("PaymentController")
@RequestMapping("/Payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/list")
    public List<Payment> getPaymentList(){
        return paymentService.findAll();
    }

}
