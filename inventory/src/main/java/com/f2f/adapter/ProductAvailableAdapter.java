package com.f2f.adapter;

import com.f2f.dao.InventoryRepository;
import com.f2f.port.ProductInventoryPort;
import org.springframework.stereotype.Component;

// InventoryAdapter.java در ماژول inventory
@Component
public class ProductAvailableAdapter implements ProductInventoryPort {
    private final InventoryRepository inventoryRepository;

    public ProductAvailableAdapter(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public boolean isProductAvailable(Long productId) {
        return inventoryRepository.isInStock(productId);
    }
}

