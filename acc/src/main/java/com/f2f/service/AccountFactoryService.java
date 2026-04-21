package com.f2f.service;

import com.f2f.dto.CreateAccountRequest;
import com.f2f.dto.UpdateAccountRequest;
import com.f2f.entity.AccountsChart;

public interface AccountFactoryService {
    AccountsChart createAccount(AccountsChart parent, CreateAccountRequest dto);
    void updateAccount(AccountsChart account, UpdateAccountRequest dto);
}

