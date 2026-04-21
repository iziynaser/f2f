package com.f2f.service;

import com.f2f.dto.AccountTreeNode;
import com.f2f.dto.CreateAccountRequest;
import com.f2f.dto.UpdateAccountRequest;
import com.f2f.entity.AccountsChart;

import java.util.List;

public interface ChartOfAccountService {
    AccountsChart createAccount(CreateAccountRequest dto);
    AccountsChart updateAccount(Long id, UpdateAccountRequest dto);
    AccountsChart getById(Long id);
    List<AccountsChart> getAll();
    List<AccountTreeNode> getAccountTree();
}

