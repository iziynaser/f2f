package com.f2f.response;


import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/*
برای مدیریت مستقیم خطا استفاده می شود
 */

@Getter
@Builder
public class ApiErrorResponse {

    @Builder.Default
    private final String status = "ERROR";

    private final String errorCode;       // مثلاً: "NOT_FOUND", "BAD_REQUEST"

    private final String message;         // پیام قابل نمایش برای کاربر

    private final String detail;          // اطلاعات دقیق‌تر برای برنامه‌نویس یا لاگ

    @Builder.Default
    private final LocalDateTime dateTime = LocalDateTime.now(ZoneOffset.UTC);
}
