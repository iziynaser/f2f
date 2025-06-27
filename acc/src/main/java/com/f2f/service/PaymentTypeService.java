package com.f2f.service;

import com.f2f.dao.PaymentTypeDao;
import com.f2f.entity.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("PaymentTypeService")
public class PaymentTypeService {

    @Autowired
    PaymentTypeDao paymentTypeDao;

    public List<PaymentType> findAll(){
        return (List<PaymentType>) paymentTypeDao.findAll();
    }

}
