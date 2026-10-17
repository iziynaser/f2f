package ir.verjik.service;

import ir.verjik.dto.chartOfAccount.AccountTreeNode;
import ir.verjik.dto.chartOfAccount.CreateAccountRequest;
import ir.verjik.dto.chartOfAccount.UpdateAccountRequest;
import ir.verjik.entity.AccountingChart;

import java.util.List;

public interface ChartOfAccountService {
    AccountingChart createAccount(CreateAccountRequest dto);
    AccountingChart updateAccount(Long id, UpdateAccountRequest dto);
    AccountingChart getById(Long id);
    List<AccountingChart> getAll();
    List<AccountTreeNode> getAccountTree();

    void deleteAccount(Long id);
}

