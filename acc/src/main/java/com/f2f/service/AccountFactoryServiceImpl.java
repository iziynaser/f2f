package com.f2f.service;

import com.f2f.dto.chartOfAccount.CreateAccountRequest;
import com.f2f.dto.chartOfAccount.UpdateAccountRequest;
import com.f2f.entity.AccountingChart;
import com.f2f.enums.AccountLevel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountFactoryServiceImpl implements AccountFactoryService {

    private final AccountCodeGeneratorService codeGenerator;

    public AccountFactoryServiceImpl(AccountCodeGeneratorService codeGenerator) {
        this.codeGenerator = codeGenerator;
    }

    @Override
    public AccountingChart createAccount(AccountingChart parent, CreateAccountRequest dto) {

        AccountingChart acc = new AccountingChart();

        acc.setParentAccount(parent);
        acc.setName(dto.name);
        acc.setLevelIndex(parent.getLevelIndex() + 1);
        acc.setAccountLevel(getNextLevel(parent.getAccountLevel()));
        // این بخش اگر شما سیاست دیگری دارید تغییر می‌دهیم

        acc.setAccountCode(codeGenerator.generateChildCode(parent));

        acc.setAccountNature(dto.accountNature != null ? dto.accountNature : parent.getAccountNature());
        acc.setNormalBalance(dto.debitCreditType != null ? dto.debitCreditType : parent.getNormalBalance());

        acc.setPostable(dto.postable != null ? dto.postable : true);
        acc.setActive(dto.active != null ? dto.active : true);

        return acc;
    }

    private AccountLevel getNextLevel(AccountLevel parent) {
        int ordinal = parent.ordinal() ;
        if(ordinal + 1 >= AccountLevel.values().length ) {
            return parent;
        }
        return AccountLevel.values()[parent.ordinal() + 1];
    }

    @Override
    public void updateAccount(AccountingChart acc, UpdateAccountRequest dto) {

        if (dto.name != null)
            acc.setName(dto.name);

        if (dto.postable != null)
            acc.setPostable(dto.postable);

        if (dto.active != null)
            acc.setActive(dto.active);

        if (dto.color != null)
            acc.setColor(dto.color);

        if (dto.description != null)
            acc.setDescription(dto.description);
    }
}
