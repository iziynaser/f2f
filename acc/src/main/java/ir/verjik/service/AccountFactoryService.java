package ir.verjik.service;

import ir.verjik.dto.chartOfAccount.CreateAccountRequest;
import ir.verjik.dto.chartOfAccount.UpdateAccountRequest;
import ir.verjik.entity.AccountingChart;

public interface AccountFactoryService {
    AccountingChart createAccount(AccountingChart parent, CreateAccountRequest dto);
    void updateAccount(AccountingChart account, UpdateAccountRequest dto);
}

