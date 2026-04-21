package com.f2f.service;

import com.f2f.entity.AccountsChart;

public interface AccountCodeGeneratorService {
    String generateChildCode(AccountsChart parent);
}

