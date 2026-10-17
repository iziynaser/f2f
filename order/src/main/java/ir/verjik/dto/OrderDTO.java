package ir.verjik.dto;

import ir.verjik.enums.OrderStatusEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

    private Long id;
    private String orderCode;
    private Long customerId;
    private LocalDateTime orderDate;

    private LocalDate deliveryDate;
    private LocalTime deliveryTime;

    private OrderStatusEnum currentStatus;
    private Long totalAmount;

    private List<OrderItemDTO> items;
    private List<OrderStatusDTO> statusHistory;
}
