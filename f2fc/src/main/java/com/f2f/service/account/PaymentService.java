package com.f2f.service.account;

import com.f2f.dao.acc.PaymentDao;
import com.f2f.entity.acc.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("PaymentService")
public class PaymentService {

    @Autowired
    PaymentDao paymentDao;

    public List<Payment> findAll(){
        return (List<Payment>)paymentDao.findAll();
    }

}
