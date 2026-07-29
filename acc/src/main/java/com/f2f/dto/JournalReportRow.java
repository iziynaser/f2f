package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
public class JournalReportRow {

    private LocalDate transactionDate;

    private String transactionNumber;

    private String description;

    private String accountCode;

    private String accountName;

    private BigDecimal debit;

    private BigDecimal credit;

    private Integer lineNumber;

}
