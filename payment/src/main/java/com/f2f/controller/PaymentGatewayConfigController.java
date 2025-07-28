package com.f2f.controller;

import com.f2f.entity.PaymentGatewayConfig;
import com.f2f.enums.PaymentGatewayType;
import com.f2f.service.PaymentGatewayConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment/gateway")
@RequiredArgsConstructor
public class PaymentGatewayConfigController {

    private final PaymentGatewayConfigService configService;

    @GetMapping("/active")
    public ResponseEntity<List<PaymentGatewayConfig>> getActiveGateways() {
        return ResponseEntity.ok(configService.getActiveGateways());
    }

    @PostMapping("/default/{gatewayType}")
    public ResponseEntity<Void> setDefaultGateway(@PathVariable PaymentGatewayType gatewayType) {
        configService.setDefaultGateway(gatewayType);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{gatewayType}/activate")
    public ResponseEntity<Void> activateGateway(
            @PathVariable PaymentGatewayType gatewayType,
            @RequestParam boolean active) {
        configService.activateGateway(gatewayType, active);
        return ResponseEntity.ok().build();
    }
}
