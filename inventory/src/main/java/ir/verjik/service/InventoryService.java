package ir.verjik.service;

import ir.verjik.dao.InventoryRepository;
import ir.verjik.dao.StockBatchesRepository;
import ir.verjik.entity.Inventory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final StockBatchesRepository stockBatchesRepository;


    public int getProductQuantity(Long productId,Long warehouseId) {
        return inventoryRepository.findByProductItemIdAndWarehouseId(productId,warehouseId)
                .map(Inventory::getQuantity)
                .orElse(0);
    }

    public int getTotalQuantity(Long productId) {
        Integer total = inventoryRepository.findTotalQuantityByProductItemId(productId);
        return total==null?0:total;
    }


    // ✅ بررسی موجود بودن یک کالا (در تمام انبارها)
    public boolean isProductAvailable(Long productItemId) {
        Integer totalRemaining = stockBatchesRepository.sumRemainingByProductItemId(productItemId);
        return totalRemaining != null && totalRemaining > 0;
    }

    // ✅ بررسی موجود بودن در یک انبار خاص
    public boolean isProductAvailable(Long productItemId, Long warehouseId) {
        Integer remaining = stockBatchesRepository.sumRemainingByProductItemIdAndWarehouse(productItemId, warehouseId);
        return remaining != null && remaining > 0;
    }

    // ✅ مجموع موجودی یک کالا در همه انبارها
    public int getRemainingCountByProductItemId(Long productItemId) {
        Integer totalRemaining = stockBatchesRepository.sumRemainingByProductItemId(productItemId);
        return totalRemaining != null ? totalRemaining : 0;
    }

    // ✅ مجموع موجودی یک کالا در یک انبار خاص
    public int getRemainingCountByProductItemIdAndWarehouse(Long productItemId, Long warehouseId) {
        Integer remaining = stockBatchesRepository.sumRemainingByProductItemIdAndWarehouse(productItemId, warehouseId);
        return remaining != null ? remaining : 0;
    }

}
