package com.f2f.service.account;

import com.f2f.dao.acc.CurrencyDao;
import com.f2f.entity.acc.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("CurrencyService")
public class CurrencyService {

    @Autowired
    CurrencyDao currencyDao ;

    public List<Currency> findAll(){
        return (List<Currency>) currencyDao.findAll();
    }
}
