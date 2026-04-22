package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class BalanceSheetSectionDto {
    private String sectionName; // مثلاً "دارایی‌های جاری"
    private List<AccountBalanceDto> accounts;
    private BigDecimal total;
}

