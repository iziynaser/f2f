package ir.verjik.dao;

import ir.verjik.entity.StockIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StockInRepository extends JpaRepository<StockIn,Long> {

    List<StockIn> findByProductItemId(Long productItemId);
    List<StockIn> findByWarehouseId(Long warehouseId);
    List<StockIn> findByStockInDateBetween(Date startDate, Date endDate);
}
