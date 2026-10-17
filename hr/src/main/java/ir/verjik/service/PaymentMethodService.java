package ir.verjik.service;

import ir.verjik.dao.PaymentMethodDao;
import ir.verjik.entity.PaymentMethod;
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
