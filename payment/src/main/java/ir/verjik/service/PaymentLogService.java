package ir.verjik.service;

import ir.verjik.entity.PaymentLog;
import ir.verjik.repository.PaymentLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentLogService {

    private final PaymentLogRepository logRepository;

    public void log(Long paymentRequestId, String eventType, String message, String performedBy) {
        PaymentLog log = new PaymentLog();
        log.setPaymentRequestId(paymentRequestId);
        log.setEventType(eventType);
        log.setMessage(message);
        log.setLogTime(LocalDateTime.now());
        log.setPerformedBy(performedBy);
        logRepository.save(log);
    }
}
