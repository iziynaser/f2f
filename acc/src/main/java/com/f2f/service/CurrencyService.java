package com.f2f.service;

import com.f2f.dao.CurrencyDao;
import com.f2f.entity.Currency;
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
