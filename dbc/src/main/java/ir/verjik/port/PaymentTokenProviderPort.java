package ir.verjik.port;

public interface PaymentTokenProviderPort {
    String generatePaymentToken(Long userId);
}
