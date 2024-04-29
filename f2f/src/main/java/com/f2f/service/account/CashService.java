package com.f2f.service.account;

import com.f2f.dao.acc.CashDao;
import com.f2f.entity.acc.Cash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("CashService")
public class CashService {

    @Autowired
    CashDao cashDao;

    public List<Cash> findAll() {
        return (List<Cash>)cashDao.findAll();
    }
}
