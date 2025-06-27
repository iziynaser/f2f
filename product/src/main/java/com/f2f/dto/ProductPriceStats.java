package com.f2f.dto;

public interface ProductPriceStats {
    Long getProductId();
    Long getMinPrice();
    Long getMaxPrice();
    Double getAvgPrice();
}