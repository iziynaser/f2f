package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceHistoryDTO {
    private String fromDate ;
    private String toDate ;
    private Long price ;
    private String currency ;
    private String priceTypeName ;
}
