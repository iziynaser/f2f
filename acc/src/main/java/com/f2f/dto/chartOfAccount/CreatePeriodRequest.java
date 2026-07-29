package com.f2f.dto.chartOfAccount;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreatePeriodRequest {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
}
