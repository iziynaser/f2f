package com.f2f.service;

import com.f2f.dto.AccountTreeNode;
import com.f2f.dto.CreateAccountRequest;
import com.f2f.dto.UpdateAccountRequest;
import com.f2f.entity.AccountsChart;
import com.f2f.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ChartOfAccountServiceImpl implements ChartOfAccountService {

    private final AccountRepository accountRepository;
    private final AccountValidationService validationService;
    private final AccountFactoryService factoryService;
    private final AccountTreeBuilderService treeBuilderService;

    public ChartOfAccountServiceImpl(
            AccountRepository accountRepository,
            AccountValidationService validationService,
            AccountFactoryService factoryService,
            AccountTreeBuilderService treeBuilderService
    ) {
        this.accountRepository = accountRepository;
        this.validationService = validationService;
        this.factoryService = factoryService;
        this.treeBuilderService = treeBuilderService;
    }

    @Override
    public AccountsChart createAccount(CreateAccountRequest dto) {

        AccountsChart parent =
                accountRepository.findById(dto.parentId)
                        .orElseThrow(() -> new RuntimeException("Parent account not found"));

        validationService.validateCreate(parent, dto);

        AccountsChart newAcc = factoryService.createAccount(parent, dto);

        return accountRepository.save(newAcc);
    }

    @Override
    public AccountsChart updateAccount(Long id, UpdateAccountRequest dto) {

        AccountsChart acc = getById(id);

        validationService.validateUpdate(acc, dto);

        factoryService.updateAccount(acc, dto);

        return accountRepository.save(acc);
    }

    @Override
    @Transactional(readOnly = true)
    public AccountsChart getById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccountsChart> getAll() {
        return accountRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccountTreeNode> getAccountTree() {
        return treeBuilderService.buildTree(getAll());
    }
}
