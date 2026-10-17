package ir.verjik.service;

import ir.verjik.dto.chartOfAccount.CreateAccountRequest;
import ir.verjik.dto.chartOfAccount.UpdateAccountRequest;
import ir.verjik.entity.AccountingChart;

public interface AccountValidationService {
    void validateCreate(AccountingChart parent, CreateAccountRequest dto);
    void validateUpdate(AccountingChart account, UpdateAccountRequest dto);
}

