package ir.verjik.dao;

import ir.verjik.entity.StockTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockTransferRepository  extends JpaRepository<StockTransfer,Long> {
}
