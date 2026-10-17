package ir.verjik.reporting.order.dto;

import ir.verjik.dto.OrderItemDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CustomerOrderDetailReportDTO {
    private Long orderId;
    private String orderCode;
    private LocalDateTime orderDate;
    private String currentStatus;
    private List<OrderStatusDetailReportDTO> statusHistory;
    private List<OrderItemDTO> items;
}