package com.f2f.dao;

import com.f2f.entity.StockOut;
import com.f2f.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface StockOutRepository extends JpaRepository<StockOut, Long> {
    //List<StockOut> findByProduct(Long productId);
    List<StockOut> findByWarehouseId(Long warehouseId);
    //List<StockOut> findByStockOutDateBetween(Date startDate, Date endDate);
}
