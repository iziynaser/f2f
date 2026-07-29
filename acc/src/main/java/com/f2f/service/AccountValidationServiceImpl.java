package com.f2f.service;

import com.f2f.dto.chartOfAccount.CreateAccountRequest;
import com.f2f.dto.chartOfAccount.UpdateAccountRequest;
import com.f2f.entity.AccountingChart;
import org.springframework.stereotype.Service;

@Service
public class AccountValidationServiceImpl implements AccountValidationService {

    @Override
    public void validateCreate(AccountingChart parent, CreateAccountRequest dto) {
        if (parent == null)
            throw new RuntimeException("Parent account not found");

        if (dto.name == null || dto.name.isBlank())
            throw new RuntimeException("Account name is required");
    }

    @Override
    public void validateUpdate(AccountingChart acc, UpdateAccountRequest dto) {
        if (dto.name != null && dto.name.isBlank())
            throw new RuntimeException("Account name cannot be empty");
    }
}
