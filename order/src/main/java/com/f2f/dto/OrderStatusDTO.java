package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderStatusDTO {
    private String status;
    private LocalDateTime statusDate;
    private String comment;

}
