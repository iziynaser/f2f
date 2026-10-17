package ir.verjik.controller;

import ir.verjik.dto.StockInRequest;
import ir.verjik.service.StockInService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stock-in")
public class StockInController {
    private final StockInService stockInService;

    @PostMapping
    public ResponseEntity<Void> stockIn(@RequestBody StockInRequest request) {
        stockInService.stockIn(
                request.getProductId(),
                request.getWarehouseId(),
                request.getQuantity(),
                request.getPurchasePrice(),
                request.getReferenceNumber()
        );
        return ResponseEntity.ok().build();
    }
}
