package ir.verjik.port;

public interface InventoryPort {
    Integer sumAvailableInventory(Long productItemId);
    int getRemainingCountByProductItemId(Long productItemId);

}