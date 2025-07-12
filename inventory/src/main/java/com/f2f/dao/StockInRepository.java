package com.f2f.dao;

import com.f2f.entity.StockIn;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StockInRepository extends JpaRepository<StockIn,Integer> {

    List<StockIn> findByProductItemId(Long productItemId);
    List<StockIn> findByWarehouseId(Long warehouseId);
    List<StockIn> findByStockInDateBetween(Date startDate, Date endDate);
}
