package com.f2f.dto;

import java.math.BigDecimal;

public record BalanceGroupDTO(
        String groupCode,
        BigDecimal opening,
        BigDecimal debit,
        BigDecimal credit,
        BigDecimal closing
) {}
