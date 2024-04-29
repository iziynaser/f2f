package com.f2f.service.account;

import com.f2f.dao.acc.AccountingTransactionDao;
import com.f2f.entity.acc.AccountingTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("AccountingTransactionService")
public class AccountingTransactionService {

    @Autowired
    AccountingTransactionDao accountingTransactionDao;

    public List<AccountingTransaction> findAll() {
        return (List<AccountingTransaction>) accountingTransactionDao.findAll();
    }
}
