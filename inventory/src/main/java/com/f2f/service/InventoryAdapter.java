package com.f2f.service;

import com.f2f.dao.InventoryRepository;
import com.f2f.port.InventoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryAdapter implements InventoryPort {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Integer sumAvailableInventory(Long productItemId) {
        return inventoryRepository.sumAvailableInventory(productItemId);
    }
}
