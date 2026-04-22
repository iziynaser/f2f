package com.f2f.dto;

import com.f2f.enums.PeriodStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AccountingPeriodDto {

    private String periodName;
    private Integer fiscalYear;
    private LocalDate fromDate ;
    private LocalDate toDate;
    private Short periodNumber;
    public PeriodStatus isClosed;

}
