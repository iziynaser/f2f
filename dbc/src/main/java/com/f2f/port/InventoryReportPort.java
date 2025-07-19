package com.f2f.port;

import java.util.List;

public interface InventoryReportPort {
    List<Long> findHottestProductIdsInLastHours(int hours, int limit);
}
