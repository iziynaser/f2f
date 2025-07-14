package com.f2f.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

    private Long customerId;
    private List<OrderItemDTO> items;
    private String currentStatus;
    private LocalDateTime orderDate ;

}
