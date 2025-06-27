package com.f2f.controller;

import com.f2f.dto.OrderStatusDTO;
import com.f2f.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/f2f/order-status")
public class OrderStatusController {

    @Autowired
    private  OrderStatusService orderStatusService;

//    //public
//
//    public OrderStatusController(OrderStatusService orderStatusService) {
//        this.orderStatusService = orderStatusService;
//    }

    @PostMapping
    public ResponseEntity<OrderStatusDTO> createStatus(@RequestBody OrderStatusDTO orderStatusDTO) {
        OrderStatusDTO created = orderStatusService.createStatus(orderStatusDTO);
        return ResponseEntity.ok(created);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<OrderStatusDTO> getStatus(@PathVariable Long id) {
//        return orderStatusService.getStatusById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderStatusDTO>> getStatusesByOrder(@PathVariable Long orderId) {
        List<OrderStatusDTO> statuses = orderStatusService.getStatusesByOrderId(orderId);
        return ResponseEntity.ok(statuses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderStatusDTO> updateStatus(@PathVariable Long id, @RequestBody OrderStatusDTO orderStatusDTO) {
        OrderStatusDTO updated = orderStatusService.updateStatus(id, orderStatusDTO);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Long id) {
        orderStatusService.deleteStatus(id);
        return ResponseEntity.noContent().build();
    }
}
