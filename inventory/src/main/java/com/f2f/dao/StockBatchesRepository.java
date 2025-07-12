package com.f2f.dao;

import com.f2f.entity.StockBatches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StockBatchesRepository  extends JpaRepository<StockBatches, Long> {

    @Query("SELECT SUM(sb.remaining) FROM StockBatches sb WHERE sb.productItemId = :productItemId")
    Integer sumRemainingByProductItemId(@Param("productItemId") Long productItemId);

    @Query("SELECT SUM(sb.remaining) FROM StockBatches sb WHERE sb.productItemId = :productItemId AND sb.warehouse.id = :warehouseId")
    Integer sumRemainingByProductItemIdAndWarehouse(@Param("productItemId") Long productItemId,
                                                    @Param("warehouseId") Long warehouseId);


}
