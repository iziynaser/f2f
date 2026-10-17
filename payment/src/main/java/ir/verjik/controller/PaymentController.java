package ir.verjik.controller;

import ir.verjik.dto.PaymentInitRequestDTO;
import ir.verjik.dto.PaymentInitResponseDTO;
import ir.verjik.dto.PaymentVerifyRequestDTO;
import ir.verjik.dto.PaymentVerifyResponseDTO;
import ir.verjik.response.ApiSuccessResponse;
import ir.verjik.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("f2f/api/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/initiate")
    public ResponseEntity<ApiSuccessResponse<PaymentInitResponseDTO>> initiate(@RequestBody PaymentInitRequestDTO dto) {
        Long userId = 1L;
        PaymentInitResponseDTO response = paymentService.initiatePayment(dto, userId);
        ApiSuccessResponse<PaymentInitResponseDTO> apiResponse = ApiSuccessResponse.of(response, "پرداخت با موفقیت آغاز شد");
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/verify")
    public ResponseEntity<ApiSuccessResponse<PaymentVerifyResponseDTO>> verify(@RequestBody PaymentVerifyRequestDTO dto) {
        Long userId = 1L;
        PaymentVerifyResponseDTO response = paymentService.verifyPayment(dto, userId);
        ApiSuccessResponse<PaymentVerifyResponseDTO> apiResponse = ApiSuccessResponse.of(response, "پرداخت با موفقیت تأیید شد");
        return ResponseEntity.ok(apiResponse);
    }
}
