package com.f2f.controller;

import com.f2f.dto.PaymentInitRequestDTO;
import com.f2f.dto.PaymentInitResponseDTO;
import com.f2f.dto.PaymentVerifyRequestDTO;
import com.f2f.dto.PaymentVerifyResponseDTO;
import com.f2f.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/initiate")
    public ResponseEntity<PaymentInitResponseDTO> initiate(@RequestBody PaymentInitRequestDTO dto) {
        return ResponseEntity.ok(paymentService.initiatePayment(dto));
    }

    @PostMapping("/verify")
    public ResponseEntity<PaymentVerifyResponseDTO> verify(@RequestBody PaymentVerifyRequestDTO dto) {
        return ResponseEntity.ok(paymentService.verifyPayment(dto));
    }
}
