package com.f2f.service;

import com.f2f.dto.CreateAccountRequest;
import com.f2f.dto.UpdateAccountRequest;
import com.f2f.entity.AccountsChart;

public interface AccountValidationService {
    void validateCreate(AccountsChart parent, CreateAccountRequest dto);
    void validateUpdate(AccountsChart account, UpdateAccountRequest dto);
}

