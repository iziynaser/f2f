package com.f2f.service.account;


import com.f2f.dao.acc.AccountResourceTypeDao;
import com.f2f.entity.acc.AccountResourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("AccountResourceTypeService")
public class AccountResourceTypeService {

    @Autowired
    AccountResourceTypeDao accountResourceTypeDao;

    public List<AccountResourceType> findAll() {
        return (List<AccountResourceType>) accountResourceTypeDao.findAll();
    }
}
