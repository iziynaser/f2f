package com.f2f.service.account;

import com.f2f.dao.acc.TransactionDetailDao;
import com.f2f.entity.acc.TransactionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("TransactionDetailService")
public class TransactionDetailService {

    @Autowired
    TransactionDetailDao transactionDetailDao;

    public List<TransactionDetail> findAll(){
        return (List<TransactionDetail>)transactionDetailDao.findAll();
    }

}
