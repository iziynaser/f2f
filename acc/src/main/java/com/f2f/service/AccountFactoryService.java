package com.f2f.service;

import com.f2f.dto.chartOfAccount.CreateAccountRequest;
import com.f2f.dto.chartOfAccount.UpdateAccountRequest;
import com.f2f.entity.AccountingChart;

public interface AccountFactoryService {
    AccountingChart createAccount(AccountingChart parent, CreateAccountRequest dto);
    void updateAccount(AccountingChart account, UpdateAccountRequest dto);
}

