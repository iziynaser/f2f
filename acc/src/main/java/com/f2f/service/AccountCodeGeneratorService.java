package com.f2f.service;

import com.f2f.entity.AccountingChart;

public interface AccountCodeGeneratorService {
    String generateChildCode(AccountingChart parent);
}

