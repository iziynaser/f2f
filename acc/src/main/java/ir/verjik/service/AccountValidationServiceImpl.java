package ir.verjik.service;

import ir.verjik.dto.chartOfAccount.CreateAccountRequest;
import ir.verjik.dto.chartOfAccount.UpdateAccountRequest;
import ir.verjik.entity.AccountingChart;
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
