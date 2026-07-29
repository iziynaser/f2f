package com.f2f.service;

import com.f2f.dto.chartOfAccount.AccountTreeNode;
import com.f2f.dto.chartOfAccount.CreateAccountRequest;
import com.f2f.dto.chartOfAccount.UpdateAccountRequest;
import com.f2f.entity.AccountingChart;

import java.util.List;

public interface ChartOfAccountService {
    AccountingChart createAccount(CreateAccountRequest dto);
    AccountingChart updateAccount(Long id, UpdateAccountRequest dto);
    AccountingChart getById(Long id);
    List<AccountingChart> getAll();
    List<AccountTreeNode> getAccountTree();

    void deleteAccount(Long id);
}

