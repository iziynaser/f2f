package com.f2f.controller.hr;

import com.f2f.entity.hr.PaymentMethod;
import com.f2f.service.hr.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("PaymentMethodController")
@RequestMapping("/PaymentMethod")
public class PaymentMethodController{

    @Autowired
    PaymentMethodService paymentMethodService;

    @GetMapping("/list")
    public List<PaymentMethod> getPaymentMethodList(){
        List<PaymentMethod> list = paymentMethodService.findAll();
        return list;
    }
}
