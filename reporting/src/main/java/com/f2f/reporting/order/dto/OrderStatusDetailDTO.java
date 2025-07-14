package com.f2f.reporting.order.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderStatusDetailDTO {

    private String comment;
    private LocalDateTime statusDate;
    private String status;

}
