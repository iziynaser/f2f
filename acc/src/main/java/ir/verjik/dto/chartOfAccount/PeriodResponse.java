package ir.verjik.dto.chartOfAccount;

import java.time.LocalDate;

public class PeriodResponse {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status; // OPEN, CLOSED
}
