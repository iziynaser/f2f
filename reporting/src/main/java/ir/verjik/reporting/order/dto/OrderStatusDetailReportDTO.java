package ir.verjik.reporting.order.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderStatusDetailReportDTO {
    private String status;
    private LocalDateTime statusDate;
    private String comment;
}
