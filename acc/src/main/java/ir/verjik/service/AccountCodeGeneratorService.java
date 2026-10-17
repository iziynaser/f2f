package ir.verjik.service;

import ir.verjik.entity.AccountingChart;

public interface AccountCodeGeneratorService {
    String generateChildCode(AccountingChart parent);
}

