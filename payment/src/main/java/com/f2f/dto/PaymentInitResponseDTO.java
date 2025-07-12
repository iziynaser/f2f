package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentInitResponseDTO {
    private String redirectUrl;
    private String authority;
}