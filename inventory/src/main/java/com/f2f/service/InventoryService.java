package com.f2f.service;

import com.f2f.dao.InventoryRepository;
import com.f2f.entity.Inventory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public boolean isProductAvailable(Long productId,Long warehouseId) {
        return inventoryRepository.existsByProductItemIdAndWarehouseId(productId, warehouseId);
    }

    public int getProductQuantity(Long productId,Long warehouseId) {
        return inventoryRepository.findByProductItemIdAndWarehouseId(productId,warehouseId)
                .map(Inventory::getQuantity)
                .orElse(0);
    }

    public int getTotalQuantity(Long productId) {
        Integer total = inventoryRepository.findTotalQuantityByProductItemId(productId);
        return total==null?0:total;
    }
}
