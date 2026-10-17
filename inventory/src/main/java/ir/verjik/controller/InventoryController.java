package ir.verjik.controller;

import ir.verjik.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping("/isAvailable")
    public ResponseEntity<Boolean> isAvailable(@RequestParam Long productId,@RequestParam Long warehouseId) {
        boolean available = inventoryService.isProductAvailable(productId, warehouseId);
        return ResponseEntity.ok(available);
    }

    @GetMapping("/quantity")
    public ResponseEntity<Integer> getQuantity(@RequestParam Long productId,@RequestParam Long warehouseId) {
        int quantity = inventoryService.getProductQuantity(productId, warehouseId);
        return ResponseEntity.ok(quantity);
    }
}
