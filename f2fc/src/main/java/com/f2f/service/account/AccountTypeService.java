package com.f2f.service.account;

import com.f2f.dao.acc.AccountTypeDao;
import com.f2f.entity.acc.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("AccountTypeService")
public class AccountTypeService {

    @Autowired
    AccountTypeDao accountTypeDao;

    public List<AccountType> findAll() {
        return (List<AccountType>) accountTypeDao.findAll();
    }
}
