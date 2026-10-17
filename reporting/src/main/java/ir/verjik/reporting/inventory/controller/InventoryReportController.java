package ir.verjik.reporting.inventory.controller;

import ir.verjik.reporting.inventory.dto.InventoryReportDTO;
import ir.verjik.reporting.inventory.dto.InventoryStockReportDTO;
import ir.verjik.reporting.inventory.service.InventoryReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory/reports")
@RequiredArgsConstructor
public class InventoryReportController {

    private final InventoryReportService inventoryReportService;

    @GetMapping("/stock")
    public ResponseEntity<List<InventoryReportDTO>> getStockReport() {
        return ResponseEntity.ok(inventoryReportService.getAllInventoryStatus());
    }

    @GetMapping("/stoc1k")
    public List<InventoryStockReportDTO> getInventoryStockReport(@RequestParam(required = false) Long warehouseId) {
        return inventoryReportService.getInventoryStockReport(warehouseId);
    }
}
