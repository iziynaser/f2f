package com.f2f.reporting.order.controller;

import com.f2f.reporting.order.dto.CustomerOrderCountReportDTO;
import com.f2f.reporting.order.dto.CustomerOrderDetailReportDTO;
import com.f2f.reporting.order.dto.CustomerOrderReportReportDTO;
import com.f2f.reporting.order.dto.OrderStatusSummaryReportDTO;
import com.f2f.reporting.order.service.OrderReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order/reports")
@RequiredArgsConstructor
public class OrderReportController {

    private final OrderReportService orderReportService;

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<CustomerOrderReportReportDTO>> getOrdersByCustomer(@PathVariable Long customerId) {
        List<CustomerOrderReportReportDTO> report = orderReportService.getOrdersForCustomer(customerId);
        return ResponseEntity.ok(report);
    }

    @GetMapping("/status-summary")
    public ResponseEntity<List<OrderStatusSummaryReportDTO>> getOrderStatusSummary() {
        return ResponseEntity.ok(orderReportService.getOrderStatusSummary());
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<CustomerOrderDetailReportDTO>> getOrdersByCustomer2(@PathVariable Long customerId) {
        List<CustomerOrderDetailReportDTO> result = orderReportService.getOrdersByCustomer(customerId);
        if (result.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/reports/customer-order-count")
    public ResponseEntity<List<CustomerOrderCountReportDTO>> getCustomerOrderCounts() {
        return ResponseEntity.ok(orderReportService.getCustomerOrderCounts());
    }
}
