package com.f2f.gateway;

import com.f2f.dto.PaymentInitResponseDTO;
import com.f2f.dto.PaymentVerifyResponseDTO;
import com.f2f.entity.PaymentRequest;
import com.f2f.enums.PaymentGatewayType;
import com.f2f.port.PaymentGatewayPort;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.UUID;

@Component
public class MockPaymentGateway implements PaymentGatewayPort {

    @Override
    public PaymentInitResponseDTO initiate(PaymentRequest request) {
        // تولید Authority
        String authority = UUID.randomUUID().toString();
        request.setAuthorityCode(authority);  // به‌روزرسانی Authority در درخواست

        // Callback URL قبلاً حاوی token شده است – فقط authority اضافه می‌شود
        String callbackUrlWithToken = request.getCallbackUrl();
        String redirectUrl = appendAuthorityToUrl(callbackUrlWithToken, authority);

        return new PaymentInitResponseDTO(redirectUrl, authority);
    }

    @Override
    public PaymentVerifyResponseDTO verify(String authority, Long amount) {
        String transactionId = "MOCK-TRX-" + authority;
        return new PaymentVerifyResponseDTO(true, transactionId, "پرداخت شبیه‌سازی شده موفق");
    }

    @Override
    public String getGatewayName() {
        return PaymentGatewayType.MOCK.name();
    }

    // ابزار کمکی برای اضافه کردن authority به URL
    private String appendAuthorityToUrl(String url, String authority) {
        try {
            URI uri = new URI(url);
            String query = uri.getQuery();
            String newQuery = (query == null || query.isEmpty())
                    ? "authority=" + authority
                    : query + "&authority=" + authority;

            URI newUri = new URI(
                    uri.getScheme(),
                    uri.getAuthority(),
                    uri.getPath(),
                    newQuery,
                    uri.getFragment()
            );
            return newUri.toString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to append authority to URL", e);
        }
    }
}
