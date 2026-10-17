package ir.verjik.port;

import java.util.List;

public interface SalesReportPort {
    List<Long> findBestSellingProductIdsInMonth(int month, int year, int limit);
}
