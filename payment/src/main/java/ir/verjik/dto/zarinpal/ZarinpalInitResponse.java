package ir.verjik.dto.zarinpal;

import lombok.Data;

@Data
public class ZarinpalInitResponse {
    private BodyData data;
    private Error error;

    @Data
    public static class BodyData {
        private String authority;
        private int code;
    }

    @Data
    public static class Error {
        private int code;
        private String message;
    }
}
