package com.f2f.reporting.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderStatusSummaryReportDTO {
    private String status;
    private Long count;
}
