package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentVerifyResponseDTO {
    private boolean success;
    private String trackingCode;
    private String message;
}