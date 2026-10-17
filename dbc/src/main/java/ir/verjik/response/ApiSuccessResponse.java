package ir.verjik.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Getter
@Builder
public class ApiSuccessResponse<T> {

    @Builder.Default
    private final String status = "OK";

    @Builder.Default
    private final String errorCode = "0";

    @Builder.Default
    private final String message = "Operation completed successfully";

    @Builder.Default
    private final String detail = "Success";

    @Builder.Default
    private final LocalDateTime dateTime = LocalDateTime.now(ZoneOffset.UTC);

    private final T body;

    public static <T> ApiSuccessResponse<T> of(T body, String message) {
        return ApiSuccessResponse.<T>builder()
                .body(body)
                .message(message)
                .build();
    }

    public static <T> ApiSuccessResponse<T> empty(String message) {
        return ApiSuccessResponse.<T>builder()
                .message(message)
                .build();
    }

}
