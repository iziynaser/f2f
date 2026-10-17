package ir.verjik.controller;

import ir.verjik.dto.DeliveryDTO;
import ir.verjik.service.DeliveryService;
import ir.verjik.service.OstanService;
import ir.verjik.service.ShahrService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
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

    @DeleteMapping("/{deliveryId}/user/{userId}")
    public ResponseEntity<Void> deleteDelivery(@PathVariable Long deliveryId,
                                               @PathVariable Long userId) {
        deliveryService.deleteDelivery(deliveryId, userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{deliveryId}/user/{userId}")
    public ResponseEntity<DeliveryDTO> getDelivery(@PathVariable Long deliveryId,
                                                   @PathVariable Long userId) {
        DeliveryDTO dto = deliveryService.getDeliveryById(deliveryId, userId);
        return ResponseEntity.ok(dto);
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DeliveryDTO>> getAllDeliveries(@PathVariable Long userId) {
        List<DeliveryDTO> deliveries = deliveryService.getAllDeliveriesForUser(userId);
        return ResponseEntity.ok(deliveries);
    }

    @PostMapping("/{deliveryId}/default/user/{userId}")
    public ResponseEntity<Void> setDefaultDelivery(@PathVariable Long deliveryId,
                                                   @PathVariable Long userId) {
        deliveryService.setDefaultDelivery(deliveryId, userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}/default")
    public ResponseEntity<DeliveryDTO> getDefaultDelivery(@PathVariable Long userId) {
        DeliveryDTO defaultDelivery = deliveryService.getDefaultDeliveryForUser(userId);
        return ResponseEntity.ok(defaultDelivery);
    }

}
