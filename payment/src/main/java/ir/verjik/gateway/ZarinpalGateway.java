package ir.verjik.gateway;

import ir.verjik.config.GatewayRateLimiter;
import ir.verjik.dto.PaymentInitResponseDTO;
import ir.verjik.dto.PaymentVerifyResponseDTO;
import ir.verjik.dto.zarinpal.ZarinpalInitResponse;
import ir.verjik.dto.zarinpal.ZarinpalVerifyResponse;
import ir.verjik.entity.PaymentGatewayConfig;
import ir.verjik.entity.PaymentRequest;
import ir.verjik.enums.PaymentGatewayType;
import ir.verjik.port.PaymentGatewayPort;
import ir.verjik.service.PaymentGatewayConfigService;
import io.github.bucket4j.Bucket;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ZarinpalGateway implements PaymentGatewayPort {
    private final GatewayRateLimiter rateLimiter;
    private final RestTemplate restTemplate = new RestTemplate();
    private final PaymentGatewayConfigService configService;

    private static final String SANDBOX_REQUEST_URL = "https://sandbox.zarinpal.com/pg/rest/WebGate/PaymentRequest.json";
    private static final String SANDBOX_VERIFY_URL = "https://sandbox.zarinpal.com/pg/rest/WebGate/PaymentVerification.json";

    private static final String LIVE_REQUEST_URL = "https://api.zarinpal.com/pg/v4/payment/request.json";
    private static final String LIVE_VERIFY_URL = "https://api.zarinpal.com/pg/v4/payment/verify.json";

    @Override
    public PaymentInitResponseDTO initiate(PaymentRequest request) {

        Bucket bucket = rateLimiter.resolveBucket("ZARINPAL");
        if (!bucket.tryConsume(1)) {
            throw new RuntimeException("Rate limit exceeded for ZARINPAL gateway.");
        }

        // دریافت تنظیمات از DB
        PaymentGatewayConfig config = configService.getConfig(PaymentGatewayType.ZARINPAL);

        String url = config.isSandbox() ? SANDBOX_REQUEST_URL : LIVE_REQUEST_URL;

        Map<String, Object> payload = new HashMap<>();
        payload.put("merchant_id", config.getMerchantId());
        payload.put("amount", request.getAmount());
        payload.put("callback_url", config.getCallbackUrl());
        payload.put("description", "پرداخت سفارش #" + request.getOrderId());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(payload, headers);

        ResponseEntity<ZarinpalInitResponse> response =
                restTemplate.postForEntity(url, entity, ZarinpalInitResponse.class);

        ZarinpalInitResponse.BodyData data = response.getBody().getData();

        request.setAuthorityCode(data.getAuthority());

        return new PaymentInitResponseDTO(
                "https://www.zarinpal.com/pg/StartPay/" + data.getAuthority(),
                data.getAuthority()
        );
    }

    @Override
    public PaymentVerifyResponseDTO verify(String authority, Long amount) {

        Bucket bucket = rateLimiter.resolveBucket("ZARINPAL");
        if (!bucket.tryConsume(1)) {
            throw new RuntimeException("Rate limit exceeded for ZARINPAL gateway.");
        }

        // دریافت تنظیمات از DB
        PaymentGatewayConfig config = configService.getConfig(PaymentGatewayType.ZARINPAL);

        String url = config.isSandbox() ? SANDBOX_VERIFY_URL : LIVE_VERIFY_URL;

        Map<String, Object> payload = new HashMap<>();
        payload.put("merchant_id", config.getMerchantId());
        payload.put("amount", amount);
        payload.put("authority", authority);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(payload, headers);

        ResponseEntity<ZarinpalVerifyResponse> response =
                restTemplate.postForEntity(url, entity, ZarinpalVerifyResponse.class);

        ZarinpalVerifyResponse.BodyData data = response.getBody().getData();

        return new PaymentVerifyResponseDTO(
                true,
                data.getRefId().toString(),
                "پرداخت موفق با کد پیگیری: " + data.getRefId()
        );
    }

    @Override
    public String getGatewayName() {
        return PaymentGatewayType.ZARINPAL.name();
    }
}
