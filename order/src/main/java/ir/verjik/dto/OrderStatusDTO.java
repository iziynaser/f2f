package ir.verjik.dto;

import ir.verjik.enums.OrderStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderStatusDTO {
    private Long id;
    private OrderStatusEnum status;
    private LocalDateTime statusDate;
    private String comment;
    private LocalDateTime  startDate;
    private LocalDateTime  endDate;
    private LocalDateTime  registerDate;
    // اختیاری:
    private LocalDateTime deliveryDate;
}
