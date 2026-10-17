package ir.verjik.service;

import ir.verjik.dao.InventoryRepository;
import ir.verjik.dao.StockInRepository;
import ir.verjik.dao.WarehouseRepository;
import ir.verjik.entity.Inventory;
import ir.verjik.entity.StockIn;
import ir.verjik.entity.Warehouse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StockInService {
    private final StockInRepository stockInRepository;
    private final InventoryRepository inventoryRepository;
    private final WarehouseRepository warehouseRepository;


    public void stockIn(Long productId, Long warehouseId, int quantity, BigDecimal price,String reference) {
        StockIn stockIn = new StockIn();

        Warehouse warehouse = warehouseRepository.findById(warehouseId)
                .orElseThrow(() -> new RuntimeException("Warehouse not found"));

        //stockIn.setProductId(productId);
        stockIn.setWarehouse(warehouse);
        stockIn.setQuantity(quantity);
        stockIn.setStockInDate(LocalDateTime.now());
        stockIn.setPurchasePrice(price);
        stockIn.setReferenceNumber(reference);
        stockInRepository.save(stockIn);

        Inventory inventory = inventoryRepository.findByProductItemIdAndWarehouseId(productId,warehouseId)
                .orElseGet(()->{
                    Inventory inv = new Inventory();
                   // inv.setProductId(productId);
                    inv.setWarehouse(warehouse);
                    inv.setQuantity(0);
                    return inv;

                });
        inventory.setQuantity(inventory.getQuantity()+quantity);
        inventoryRepository.save(inventory);
    }
}
