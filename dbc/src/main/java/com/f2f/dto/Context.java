package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class Context {

    private Long productItemId;
    private Long personId;
    private Long brandId;
    private Long categoryId;
    private String geoLocation;
    private Integer quantity = 1;         // مقدار پیش‌فرض 1
    private Long totalAmount = 0L;        // مبلغ کل سفارش یا کالا
    private LocalDate requestDate;
}
