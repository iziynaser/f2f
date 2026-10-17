package ir.verjik.reporting.sales.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class SalesReportDTO {

    private BigDecimal totalAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer count ;
}
