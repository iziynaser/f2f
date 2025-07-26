package com.f2f.controller;

import com.f2f.entity.other.DeliveryDTO;
import com.f2f.service.DeliveryService;
import com.f2f.service.OstanService;
import com.f2f.service.ShahrService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/f2f/delivery")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;
    private final OstanService ostanService;
    private final ShahrService shahrService;

    @PostMapping
    public ResponseEntity<DeliveryDTO> createDelivery(@RequestBody DeliveryDTO dto) {
        DeliveryDTO created = deliveryService.createDelivery(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryDTO> updateDelivery(@PathVariable Long id,
                                                      @RequestBody DeliveryDTO dto) {
        DeliveryDTO updated = deliveryService.updateDelivery(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}/user/{userId}")
    public ResponseEntity<Void> deleteDelivery(@PathVariable Long id,
                                               @PathVariable Long userId) {
        deliveryService.deleteDelivery(id, userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/user/{userId}")
    public ResponseEntity<DeliveryDTO> getDelivery(@PathVariable Long id,
                                                   @PathVariable Long userId) {
        DeliveryDTO dto = deliveryService.getDeliveryById(id, userId);
        return ResponseEntity.ok(dto);
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DeliveryDTO>> getAllDeliveries(@PathVariable Long userId) {
        List<DeliveryDTO> deliveries = deliveryService.getAllDeliveriesForUser(userId);
        return ResponseEntity.ok(deliveries);
    }

    @PostMapping("/{id}/default/user/{userId}")
    public ResponseEntity<Void> setDefaultDelivery(@PathVariable Long id,
                                                   @PathVariable Long userId) {
        deliveryService.setDefaultDelivery(id, userId);
        return ResponseEntity.ok().build();
    }

}
