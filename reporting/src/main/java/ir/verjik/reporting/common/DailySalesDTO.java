package ir.verjik.reporting.common;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DailySalesDTO {
    private LocalDate date;
    private Long totalSalesAmount;

    public DailySalesDTO(LocalDate date, Long totalSalesAmount) {
        this.date = date;
        this.totalSalesAmount = totalSalesAmount;
    }
}
