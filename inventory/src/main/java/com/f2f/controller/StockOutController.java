package com.f2f.controller;

import com.f2f.dto.StockOutRequest;
import com.f2f.service.StockOutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stock-out")
public class StockOutController {
    private final StockOutService stockOutService;

    @PostMapping
    public ResponseEntity<Void> stockOut(@RequestBody StockOutRequest request) {
        stockOutService.stockOut(
                request.getProductId(),
                request.getWarehouseId(),
                request.getQuantity(),
                request.getReason(),
                request.getReceiverName()
        );
        return ResponseEntity.ok().build();
    }
}
