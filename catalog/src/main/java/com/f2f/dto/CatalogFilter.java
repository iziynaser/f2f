package com.f2f.dto;

import lombok.Data;

@Data
public class CatalogFilter {
    private Long categoryId;
    private Long brandId;
    private Integer minDiscountPercent;
    private Boolean onlyAvailable;
    private Boolean mostSoldInLastDays;
    private Integer days; // مثلا 7 روز اخیر
}
