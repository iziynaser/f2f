package com.f2f.controller.account;

import com.f2f.entity.acc.PaymentType;
import com.f2f.service.account.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("PaymentTypeController")
@RequestMapping("/PaymentType")
public class PaymentTypeController {

    @Autowired
    PaymentTypeService paymentTypeService;

    @GetMapping("/list")
    public List<PaymentType> getPaymentTypeList(){
        return paymentTypeService.findAll();
    }


}
