package com.f2f.service;

import com.f2f.dto.PaymentVerifyResponseDTO;
import com.f2f.entity.PaymentRequest;
import com.f2f.entity.PaymentTransaction;
import com.f2f.enums.PaymentStatus;
import com.f2f.enums.PaymentType;
import com.f2f.repository.PaymentTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentTransactionService {

    private final PaymentTransactionRepository transactionRepository;

    /**
     * ایجاد تراکنش جدید برای یک پرداخت.
     */
    public PaymentTransaction createTransaction(PaymentRequest req, PaymentVerifyResponseDTO dto) {
        PaymentTransaction tx = new PaymentTransaction();
        tx.setOrderId(req.getOrderId());
        tx.setAmount(req.getAmount());
        tx.setCurrency("IRR"); // می‌توانید configurable کنید
        tx.setPaymentType(PaymentType.ONLINE); // اگر لازم بود از req بیاید
        tx.setGatewayType(req.getGateway());
        tx.setStatus(dto.isSuccess() ? PaymentStatus.SUCCESS : PaymentStatus.FAILED);
        tx.setTransactionId(dto.getTrackingCode());
        tx.setCreatedAt(LocalDateTime.now());
        tx.setUpdatedAt(LocalDateTime.now());
        return transactionRepository.save(tx);
    }

    /**
     * دریافت تراکنش‌های یک سفارش.
     */
    public List<PaymentTransaction> findByOrderId(Long orderId) {
        return transactionRepository.findAll()
                .stream()
                .filter(t -> t.getOrderId().equals(orderId))
                .toList();
    }

    /**
     * محاسبه مجموع درآمد موفق در بازه زمانی مشخص.
     */
    public BigDecimal calculateRevenue(LocalDateTime from, LocalDateTime to) {
        return transactionRepository.findAll().stream()
                .filter(t -> t.getStatus() == PaymentStatus.SUCCESS)
                .filter(t -> t.getCreatedAt().isAfter(from) && t.getCreatedAt().isBefore(to))
                .map(t -> BigDecimal.valueOf(t.getAmount()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * گزارش آماری: تعداد و مجموع تراکنش‌های موفق، ناموفق و ...
     */
    public Map<PaymentStatus, Long> countByStatus() {
        return transactionRepository.findAll().stream()
                .collect(Collectors.groupingBy(PaymentTransaction::getStatus, Collectors.counting()));
    }

    /**
     * دریافت همه تراکنش‌ها (برای گزارش کامل یا مدیریت).
     */
    public List<PaymentTransaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<PaymentTransaction> findByTransactionId(String transactionId) {
        return transactionRepository.findAll().stream()
                .filter(tx -> transactionId.equals(tx.getTransactionId()))
                .findFirst();
    }
}
