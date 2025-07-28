package com.f2f.gateway;

import com.f2f.dto.PaymentInitResponseDTO;
import com.f2f.dto.PaymentVerifyResponseDTO;
import com.f2f.entity.PaymentRequest;
import com.f2f.enums.PaymentGatewayType;
import com.f2f.port.PaymentGatewayPort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MockPaymentGateway implements PaymentGatewayPort {

    @Override
    public PaymentInitResponseDTO initiate(PaymentRequest request) {
        // شبیه‌سازی Authority و Redirect URL
        String fakeAuthority = UUID.randomUUID().toString();
        String redirectUrl = "https://mock-payment.local/pay/" + fakeAuthority;

        request.setAuthorityCode(fakeAuthority); // ذخیره Authority در request

        return new PaymentInitResponseDTO(redirectUrl, fakeAuthority);
    }

    @Override
    public PaymentVerifyResponseDTO verify(String authority, Long amount) {
        // همیشه موفق فرض شود
        return new PaymentVerifyResponseDTO(true, "MOCK-TRX-" + authority, "پرداخت شبیه‌سازی شده موفق");
    }

    @Override
    public String getGatewayName() {
        return PaymentGatewayType.MOCK.name();
    }
}
