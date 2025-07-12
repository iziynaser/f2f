package com.f2f.dao;

import com.f2f.entity.Inventory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    boolean existsByProductItemIdAndWarehouseId(Long productItemId, Long warehouseId);

    Optional<Inventory> findByProductItemIdAndWarehouseId(Long productItemId, Long warehouseId);

    @Query("SELECT SUM(i.quantity) FROM Inventory i where i.productItemId = :productId")
    Integer findTotalQuantityByProductItemId(@Param("productId") Long productId);

    @Query("SELECT SUM(i.quantity) FROM Inventory i WHERE i.productItemId = :productItemId")
    Integer sumAvailableInventory(@Param("productItemId") Long productItemId);


}
