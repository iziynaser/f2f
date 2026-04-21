package com.f2f.service;

import com.f2f.dto.CreateAccountRequest;
import com.f2f.dto.UpdateAccountRequest;
import com.f2f.entity.AccountsChart;
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
    public AccountsChart createAccount(AccountsChart parent, CreateAccountRequest dto) {

        AccountsChart acc = new AccountsChart();

        acc.setParentAccount(parent);
        acc.setName(dto.name);
        acc.setLevelIndex(parent.getLevelIndex() + 1);
        acc.setAccountLevel(getNextLevel(parent.getAccountLevel()));
        // این بخش اگر شما سیاست دیگری دارید تغییر می‌دهیم

        acc.setAccountCode(codeGenerator.generateChildCode(parent));

        acc.setAccountNature(dto.accountNature != null ? dto.accountNature : parent.getAccountNature());
        acc.setNormalBalance(dto.normalBalance != null ? dto.normalBalance : parent.getNormalBalance());

        acc.setPostable(dto.postable != null ? dto.postable : true);
        acc.setActive(dto.active != null ? dto.active : true);

        return acc;
    }

    private AccountLevel getNextLevel(AccountLevel parent) {
        return AccountLevel.values()[parent.ordinal() + 1];
    }

    @Override
    public void updateAccount(AccountsChart acc, UpdateAccountRequest dto) {

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
