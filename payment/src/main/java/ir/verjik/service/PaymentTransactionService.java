package ir.verjik.service;

import ir.verjik.dto.*;
import ir.verjik.dto.PaymentVerifyResponseDTO;
import ir.verjik.entity.PaymentRequest;
import ir.verjik.entity.PaymentTransaction;
import ir.verjik.enums.PaymentStatus;
import ir.verjik.enums.PaymentType;
import ir.verjik.repository.PaymentTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
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
        tx.setCurrency("IRR"); // قابل کانفیگ کردن
        tx.setPaymentType(PaymentType.ONLINE); // در صورت نیاز از req تغییر بده
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
        return transactionRepository.findAll().stream()
                .filter(t -> Objects.equals(t.getOrderId(), orderId))
                .collect(Collectors.toList());
    }

    /**
     * محاسبه مجموع درآمد موفق در بازه زمانی مشخص.
     */
    public BigDecimal calculateRevenue(LocalDateTime from, LocalDateTime to) {
        return transactionRepository.findAll().stream()
                .filter(t -> t.getStatus() == PaymentStatus.SUCCESS)
                .filter(t -> !t.getCreatedAt().isBefore(from) && !t.getCreatedAt().isAfter(to))
                .map(t -> BigDecimal.valueOf(t.getAmount()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * گزارش آماری: تعداد تراکنش‌ها بر اساس وضعیت.
     */
    public Map<PaymentStatus, Long> countByStatus() {
        return transactionRepository.findAll().stream()
                .collect(Collectors.groupingBy(PaymentTransaction::getStatus, Collectors.counting()));
    }

    /**
     * دریافت همه تراکنش‌ها.
     */
    public List<PaymentTransaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    /**
     * یافتن تراکنش بر اساس شناسه تراکنش.
     */
    public Optional<PaymentTransaction> findByTransactionId(String transactionId) {
        return transactionRepository.findAll().stream()
                .filter(tx -> transactionId.equals(tx.getTransactionId()))
                .findFirst();
    }
}
