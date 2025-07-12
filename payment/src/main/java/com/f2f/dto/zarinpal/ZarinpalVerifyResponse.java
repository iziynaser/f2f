package com.f2f.dto.zarinpal;

import lombok.Data;

@Data
public class ZarinpalVerifyResponse {
    private BodyData data;
    private Error error;

    @Data
    public static class BodyData {
        private Long refId;
        private int code;
        private String cardHash;
        private String cardPan;
    }

    @Data
    public static class Error {
        private int code;
        private String message;
    }
}
