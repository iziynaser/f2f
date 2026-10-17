package ir.verjik.port;

import java.util.List;

public interface InventoryReportPort {
    List<Long> findHottestProductIdsInLastHours(int hours, int limit);
}
