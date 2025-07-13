package com.f2f.dao;

import com.f2f.entity.StockTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockTransferRepository  extends JpaRepository<StockTransfer,Long> {
}
