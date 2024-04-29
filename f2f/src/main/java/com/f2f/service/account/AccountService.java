package com.f2f.service.account;

import com.f2f.dao.acc.AccountDao;
import com.f2f.entity.acc.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("AccountService")
public class AccountService {

    @Autowired
    AccountDao accountDao;

    public List<Account> findAll() {
        return(List<Account>) accountDao.findAll();
    }
}
