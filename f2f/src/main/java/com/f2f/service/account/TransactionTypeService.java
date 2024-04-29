package com.f2f.service.account;

import com.f2f.dao.acc.TransactionTypeDao;
import com.f2f.entity.acc.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("TransactionTypeService")
public class TransactionTypeService {

    @Autowired
    TransactionTypeDao transactionTypeDao;

    public List<TransactionType> findAll() {
        return(List<TransactionType>) transactionTypeDao.findAll();
    }
}
