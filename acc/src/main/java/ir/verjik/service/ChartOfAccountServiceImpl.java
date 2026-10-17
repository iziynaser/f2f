package ir.verjik.service;

import ir.verjik.dto.chartOfAccount.AccountTreeNode;
import ir.verjik.dto.chartOfAccount.CreateAccountRequest;
import ir.verjik.dto.chartOfAccount.UpdateAccountRequest;
import ir.verjik.entity.AccountingChart;
import ir.verjik.repository.AccountsChartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ChartOfAccountServiceImpl implements ChartOfAccountService {

    private final AccountsChartRepository accountRepository;
    private final AccountValidationService validationService;
    private final AccountFactoryService factoryService;
    private final AccountTreeBuilderService treeBuilderService;

    public ChartOfAccountServiceImpl(
            AccountsChartRepository accountRepository,
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
    public AccountingChart createAccount(CreateAccountRequest dto) {

        AccountingChart parent =
                accountRepository.findById(dto.parentId)
                        .orElseThrow(() -> new RuntimeException("Parent account not found"));

        validationService.validateCreate(parent, dto);

        AccountingChart newAcc = factoryService.createAccount(parent, dto);

        return accountRepository.save(newAcc);
    }

    @Override
    public AccountingChart updateAccount(Long id, UpdateAccountRequest dto) {

        AccountingChart acc = getById(id);

        validationService.validateUpdate(acc, dto);

        factoryService.updateAccount(acc, dto);

        return accountRepository.save(acc);
    }

    @Override
    @Transactional(readOnly = true)
    public AccountingChart getById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccountingChart> getAll() {
        return accountRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccountTreeNode> getAccountTree() {
        return treeBuilderService.buildTree(getAll());
    }

    @Override
    public void deleteAccount(Long id) {

        AccountingChart acc = getById(id);
        accountRepository.delete(acc);
    }


}
