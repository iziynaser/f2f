package com.f2f.controller;

import com.f2f.dbc.domain.EntityNotFoundException;
import com.f2f.dto.OrderItemDTO;
import com.f2f.enums.OrderStatusEnum;
import com.f2f.exception.ResourceNotFoundException;
import com.f2f.response.ApiSuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f2f.dto.OrderDTO;
import com.f2f.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/f2f/orders")
public class OrderController {

    @Autowired
    private MessageSource messageSource;

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO createdOrder = orderService.createOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        try {
            OrderDTO updatedOrder = orderService.updateOrder(id, orderDTO);
            return ResponseEntity.ok(updatedOrder);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSuccessResponse<OrderDTO>> getOrder(Locale locale, @PathVariable Long id) {
        OrderDTO result = orderService.getOrderById(id)
                .orElseThrow(() -> new ResourceNotFoundException("order.not.found", new Object[]{id}));

        String successMsg = messageSource.getMessage("order.retrieved.success",null,locale);

        ApiSuccessResponse<OrderDTO> response = ApiSuccessResponse.<OrderDTO>builder()
                .message(successMsg)
                .detail(null)
                .body(result)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/customer/{customerId}/{status}")
    public ResponseEntity<List<OrderDTO>> getOrdersByCustomerAndStatus(
            @PathVariable Long customerId,
            @PathVariable OrderStatusEnum status) {
        List<OrderDTO> orders = orderService.getOrdersByCustomerAndStatus(customerId, status);
        return ResponseEntity.ok(orders);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{orderCode}/items")
    public ResponseEntity<List<OrderItemDTO>> getOrderItems(@PathVariable String orderCode) {
        List<OrderItemDTO> items = orderService.getOrderItemsByOrderCode(orderCode);
        return ResponseEntity.ok(items);
    }
}
