package com.f2f.reporting.order.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerOrderReportReportDTO {
    private Long orderId;
    private String orderCode;
    private LocalDateTime orderDate;
    private String currentStatus;
    private Long totalAmount;
    private Integer itemCount;
}
