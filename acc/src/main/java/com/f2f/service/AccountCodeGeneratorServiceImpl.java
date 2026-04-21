package com.f2f.service;

import com.f2f.entity.AccountsChart;
import com.f2f.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class AccountCodeGeneratorServiceImpl implements AccountCodeGeneratorService {

    private final AccountRepository accountRepository;

    public AccountCodeGeneratorServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public String generateChildCode(AccountsChart parent) {

        List<AccountsChart> children =
                accountRepository.findByParentAccountId(parent.getId());

        children.sort(Comparator.comparing(AccountsChart::getAccountCode));

        if (children.isEmpty()) {
            return parent.getAccountCode() + "01";
        }

        String lastCode = children.get(children.size() - 1).getAccountCode();

        String lastTwoDigits = lastCode.substring(lastCode.length() - 2);
        int next = Integer.parseInt(lastTwoDigits) + 1;

        return parent.getAccountCode() + String.format("%02d", next);
    }

}
