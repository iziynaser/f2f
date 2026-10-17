package ir.verjik.port;

// ProductSalesPort.java (دریافت اطلاعات فروش)

import java.util.List;

public interface ProductSalesPort {
    List<Long> getTopSellingProductIdsInLastDays(int days, int limit);
}
