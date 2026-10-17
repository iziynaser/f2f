package ir.verjik.controller;

import ir.verjik.entity.PaymentGatewayConfig;
import ir.verjik.enums.PaymentGatewayType;
import ir.verjik.response.ApiSuccessResponse;
import ir.verjik.service.PaymentGatewayConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment/gateway")
@RequiredArgsConstructor
public class PaymentGatewayConfigController {

    private final PaymentGatewayConfigService configService;

    @GetMapping("/active")
    public ResponseEntity<ApiSuccessResponse<List<PaymentGatewayConfig>>> getActiveGateways() {
        List<PaymentGatewayConfig> gateways = configService.getActiveGateways();
        ApiSuccessResponse<List<PaymentGatewayConfig>> response = ApiSuccessResponse.<List<PaymentGatewayConfig>>builder()
                .body(gateways)
                .message("لیست درگاه‌های فعال با موفقیت دریافت شد")
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/default/{gatewayType}")
    public ResponseEntity<ApiSuccessResponse<Void>> setDefaultGateway(@PathVariable PaymentGatewayType gatewayType) {
        configService.setDefaultGateway(gatewayType);
        ApiSuccessResponse<Void> response = ApiSuccessResponse.<Void>builder()
                .message("درگاه پیش‌فرض با موفقیت تنظیم شد")
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{gatewayType}/activate")
    public ResponseEntity<ApiSuccessResponse<Void>> activateGateway(
            @PathVariable PaymentGatewayType gatewayType,
            @RequestParam boolean active) {
        configService.activateGateway(gatewayType, active);
        ApiSuccessResponse<Void> response = ApiSuccessResponse.<Void>builder()
                .message("وضعیت فعال بودن درگاه با موفقیت تغییر یافت")
                .build();
        return ResponseEntity.ok(response);
    }
}
