package ir.verjik.reporting.inventory.repository;

import ir.verjik.entity.Inventory;
import ir.verjik.reporting.inventory.dto.InventoryReportDTO;
import ir.verjik.reporting.inventory.dto.InventoryStockReportDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryReportRepository extends JpaRepository<Inventory, Long> {

    @Query("""
    SELECT new ir.verjik.dto.InventoryReportDTO(
        i.productItemId,
        pi.name,
        i.totalStock,
        i.availableStock,
        w.name
    )
    FROM Inventory i
    JOIN ProductItem pi ON pi.id = i.productItemId
    JOIN Warehouse w ON w.id = i.warehouse.id
    """)
    List<InventoryReportDTO> getInventoryReport();

    @Query("""
        SELECT new ir.verjik.dto.report.InventoryStockReportDTO(
            i.productItem.id,
            i.productItem.name,
            i.warehouse.id,
            i.warehouse.name,
            i.quantity,
            i.reservedQuantity,
            (i.quantity - i.reservedQuantity)
        )
        FROM Inventory i
        WHERE (:warehouseId IS NULL OR i.warehouse.id = :warehouseId)
    """)
    List<InventoryStockReportDTO> findInventoryStockReport(Long warehouseId);
}
