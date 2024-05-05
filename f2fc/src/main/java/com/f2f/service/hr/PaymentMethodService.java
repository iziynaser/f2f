package com.f2f.service.hr;

import com.f2f.dao.hr.PaymentMethodDao;
import com.f2f.entity.hr.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("PaymentMethodService")
public class PaymentMethodService{

    @Autowired
    PaymentMethodDao paymentMethodDao;

    public List<PaymentMethod> findAll() {
        return (List<PaymentMethod>) paymentMethodDao.findAll();
    }
}
