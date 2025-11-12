package com.f2f.controller;

import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.dto.OrderStatusDTO;
import com.f2f.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/order-status")
public class OrderStatusController {

    private final OrderStatusService orderStatusService;

    public OrderStatusController(OrderStatusService orderStatusService) {
        this.orderStatusService = orderStatusService;
    }

    @PostMapping
    public ResponseEntity<OrderStatusDTO> createStatus(@RequestBody OrderStatusDTO orderStatusDTO) {
        OrderStatusDTO created = orderStatusService.createStatus(orderStatusDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderStatusDTO>> getStatusesByOrder(@PathVariable Long orderId) {
        List<OrderStatusDTO> statuses = orderStatusService.getStatusesByOrderId(orderId);
        return ResponseEntity.ok(statuses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderStatusDTO> updateStatus(@PathVariable Long id, @RequestBody OrderStatusDTO orderStatusDTO) {
        try {
            OrderStatusDTO updated = orderStatusService.updateStatus(id, orderStatusDTO);
            return ResponseEntity.ok(updated);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Long id) {
        orderStatusService.deleteStatus(id);
        return ResponseEntity.noContent().build();
    }
}
