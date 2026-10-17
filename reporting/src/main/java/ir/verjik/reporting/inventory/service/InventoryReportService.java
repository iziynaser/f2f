package ir.verjik.reporting.inventory.service;

import ir.verjik.reporting.inventory.dto.InventoryReportDTO;
import ir.verjik.reporting.inventory.dto.InventoryStockReportDTO;
import ir.verjik.reporting.inventory.repository.InventoryReportRepository;
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
