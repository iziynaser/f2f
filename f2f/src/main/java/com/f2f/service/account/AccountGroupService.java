package com.f2f.service.account;

import com.f2f.dao.acc.AccountGroupDao;
import com.f2f.entity.acc.AccountGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("AccountGroupService")
public class AccountGroupService {

    @Autowired
    AccountGroupDao accountGroupDao;

    public List<AccountGroup> findAll() {
        return (List<AccountGroup>)accountGroupDao.findAll();
    }
}
