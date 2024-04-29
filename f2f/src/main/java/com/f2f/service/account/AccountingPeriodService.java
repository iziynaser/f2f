package com.f2f.service.account;

import com.f2f.dao.acc.AccountingPeriodDao;
import com.f2f.entity.acc.AccountingPeriod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("AccountingPeriodService")
public class AccountingPeriodService {

    @Autowired
    AccountingPeriodDao accountingPeriodDao;

    public List<AccountingPeriod> findAll() {
        return (List<AccountingPeriod>) accountingPeriodDao.findAll();
    }
}
