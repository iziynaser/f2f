package com.f2f.service.account;

import com.f2f.dao.acc.TransactionStatusDao;
import com.f2f.entity.acc.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("TransactionStatusService")
public class TransactionStatusService {

    @Autowired
    TransactionStatusDao transactionStatusDao;

    public List<TransactionStatus> findAll() {
        return (List<TransactionStatus>) transactionStatusDao.findAll();
    }
}
