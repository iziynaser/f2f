package ir.verjik.service;

import ir.verjik.dao.InventoryRepository;
import ir.verjik.dao.StockOutRepository;
import ir.verjik.dao.WarehouseRepository;
import ir.verjik.entity.Inventory;
import ir.verjik.entity.StockOut;
import ir.verjik.entity.Warehouse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StockOutService {
    private final StockOutRepository stockOutRepository;
    private final InventoryRepository inventoryRepository;
    private final WarehouseRepository warehouseRepository;

    public void stockOut(Long productId,Long warehouseId,int quantity,String reason,String receiver) {
        Inventory inventory = inventoryRepository.findByProductItemIdAndWarehouseId(productId,warehouseId)
                .orElseThrow(() -> new IllegalArgumentException("not found"));

        if(inventory.getQuantity() < quantity) {
            throw new IllegalArgumentException("not enough");
        }

        Warehouse warehouse = warehouseRepository.findById(warehouseId)
                .orElseThrow(() -> new IllegalArgumentException("Warehouse not found"));

        StockOut stockOut = new StockOut();
        //stockOut.setProductId(productId);
        stockOut.setWarehouse(warehouse);
        stockOut.setQuantity(quantity);
        //stockOut.setReason(reason);
        stockOut.setStockDate(LocalDateTime.now());
        stockOut.setReceiverPersonId(Long.valueOf(receiver));
        stockOutRepository.save(stockOut);

        inventory.setQuantity(inventory.getQuantity() - quantity);
        inventoryRepository.save(inventory);
    }

}
