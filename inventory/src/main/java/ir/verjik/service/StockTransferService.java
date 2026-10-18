package ir.verjik.service;

import ir.verjik.dao.*;
import ir.verjik.entity.*;
import ir.verjik.dao.*;
import ir.verjik.entity.*;
import ir.verjik.enums.StockOutReason;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StockTransferService {

    private final InventoryRepository inventoryRepository;
    private final WarehouseRepository warehouseRepository;
    private final StockTransferRepository stockTransferRepository;
    private final StockOutRepository stockOutRepository;
    private final StockInRepository stockInRepository;

    public void transferStock(Long productItemId, Long sourceWarehouseId, Long destinationWarehouseId, int quantity, Long personId) {
        if (sourceWarehouseId.equals(destinationWarehouseId)) {
            throw new IllegalArgumentException("Cannot transfer to the same warehouse.");
        }

        Warehouse source = warehouseRepository.findById(sourceWarehouseId)
                .orElseThrow(() -> new RuntimeException("Source warehouse not found"));

        Warehouse dest = warehouseRepository.findById(destinationWarehouseId)
                .orElseThrow(() -> new RuntimeException("Destination warehouse not found"));

        // بررسی موجودی مبدا
        Inventory sourceInventory = inventoryRepository.findByProductItemIdAndWarehouseId(productItemId, sourceWarehouseId)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));

        if (sourceInventory.getQuantity() < quantity) {
            throw new RuntimeException("Insufficient inventory in source warehouse");
        }

        // کاهش موجودی از انبار مبدا (StockOut)
        sourceInventory.setQuantity(sourceInventory.getQuantity() - quantity);
        inventoryRepository.save(sourceInventory);

        StockOut stockOut = new StockOut();
        stockOut.setProductItemId(productItemId);
        stockOut.setWarehouse(source);
        stockOut.setQuantity(quantity);
        stockOut.setStockDate(LocalDateTime.now());
        stockOut.setReason(StockOutReason.TRANSFER);
        stockOut.setReceiverPersonId(personId);
        stockOutRepository.save(stockOut);

        // افزایش موجودی به انبار مقصد (StockIn)
        Inventory destInventory = inventoryRepository.findByProductItemIdAndWarehouseId(productItemId, destinationWarehouseId)
                .orElseGet(() -> {
                    Inventory inv = new Inventory();
                    inv.setWarehouse(dest);
                    inv.setProductItemId(productItemId);
                    inv.setQuantity(0);
                    return inv;
                });

        destInventory.setQuantity(destInventory.getQuantity() + quantity);
        inventoryRepository.save(destInventory);

        StockIn stockIn = new StockIn();
        stockIn.setProductItemId(productItemId);
        stockIn.setWarehouse(dest);
        stockIn.setQuantity(quantity);
        stockIn.setStockInDate(LocalDateTime.now());
        stockIn.setPurchasePrice(BigDecimal.ZERO); // چون از انبار به انبار منتقل شده
        stockInRepository.save(stockIn);

        // ثبت در جدول انتقال
        StockTransfer transfer = new StockTransfer();
        transfer.setProductItemId(productItemId);
        transfer.setSourceWarehouse(source);
        transfer.setDestinationWarehouse(dest);
        transfer.setQuantity(quantity);
        transfer.setTransferDate(LocalDateTime.now());
        transfer.setInitiatedBy(personId);
        stockTransferRepository.save(transfer);
    }
}
