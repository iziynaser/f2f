package com.f2f.service;

import com.f2f.dto.chartOfAccount.CreateAccountRequest;
import com.f2f.dto.chartOfAccount.UpdateAccountRequest;
import com.f2f.entity.AccountingChart;

public interface AccountValidationService {
    void validateCreate(AccountingChart parent, CreateAccountRequest dto);
    void validateUpdate(AccountingChart account, UpdateAccountRequest dto);
}

