package com.f2f.controller;

import com.f2f.entity.PaymentTransaction;
import com.f2f.enums.PaymentStatus;
import com.f2f.service.PaymentTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/f2f/api/payment/transaction")
@RequiredArgsConstructor
public class PaymentTransactionController {

    private final PaymentTransactionService transactionService;

    /**
     * دریافت همه تراکنش‌ها.
     */
    @GetMapping("/list")
    public ResponseEntity<List<PaymentTransaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    /**
     * دریافت تراکنش‌های یک سفارش خاص.
     */
    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<PaymentTransaction>> getTransactionsByOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(transactionService.findByOrderId(orderId));
    }

    /**
     * گزارش تعداد تراکنش‌ها بر اساس وضعیت.
     */
    @GetMapping("/stats/status-count")
    public ResponseEntity<Map<PaymentStatus, Long>> getStatusCounts() {
        return ResponseEntity.ok(transactionService.countByStatus());
    }

    /**
     * مجموع درآمد موفق بین دو تاریخ.
     */
    @GetMapping("/revenue")
    public ResponseEntity<BigDecimal> getRevenueBetween(
            @RequestParam String from,
            @RequestParam String to) {
        LocalDateTime fromDate = LocalDateTime.parse(from);
        LocalDateTime toDate = LocalDateTime.parse(to);
        return ResponseEntity.ok(transactionService.calculateRevenue(fromDate, toDate));
    }

    /**
     * بررسی وجود تراکنش با transactionId.
     */
    @GetMapping("/{transactionId}")
    public ResponseEntity<PaymentTransaction> getByTransactionId(@PathVariable String transactionId) {
        return transactionService.findByTransactionId(transactionId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
