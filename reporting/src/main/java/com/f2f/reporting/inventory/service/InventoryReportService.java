package com.f2f.reporting.inventory.service;

import com.f2f.dao.InventoryRepository;
import com.f2f.reporting.inventory.dto.InventoryReportDTO;
import com.f2f.reporting.inventory.dto.InventoryStockReportDTO;
import com.f2f.reporting.inventory.repository.InventoryReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryReportService {

    private final InventoryReportRepository inventoryRepository;

    public List<InventoryReportDTO> getAllInventoryStatus() {
        return inventoryRepository.getInventoryReport();
    }

    public List<InventoryStockReportDTO> getInventoryStockReport(Long warehouseId) {
        return inventoryRepository.findInventoryStockReport(warehouseId);
    }
}
