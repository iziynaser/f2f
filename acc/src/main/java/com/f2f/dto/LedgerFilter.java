package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class LedgerFilter {
    private LocalDate fromDate;
    private LocalDate toDate;
    private Long accountId;
    private Long fiscalPeriodId;
    private Long fiscalYearId;
    private String voucherNumberFrom;
    private String voucherNumberTo;
}
