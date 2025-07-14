package com.f2f.reporting.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerOrderCountReportDTO {
    private Long customerId;
    private String fullName; // firstName + lastName
    private Long orderCount;
}
