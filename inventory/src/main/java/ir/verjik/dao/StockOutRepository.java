package ir.verjik.dao;

import ir.verjik.entity.StockOut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockOutRepository extends JpaRepository<StockOut, Long> {
    //List<StockOut> findByProduct(Long productId);
    List<StockOut> findByWarehouseId(Long warehouseId);
    //List<StockOut> findByStockOutDateBetween(Date startDate, Date endDate);
}
