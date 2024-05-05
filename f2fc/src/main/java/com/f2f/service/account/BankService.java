package com.f2f.service.account;

import com.f2f.dao.acc.BankDao;
import com.f2f.entity.acc.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("BankService")
public class BankService {

    @Autowired
    BankDao bankDao;

    public List<Bank> findAll() {
        return(List<Bank>) bankDao.findAll();
    }
}
