package com.f2f.port;

public interface InventoryPort {
    Integer sumAvailableInventory(Long productItemId);
    int getRemainingCountByProductItemId(Long productItemId);

}