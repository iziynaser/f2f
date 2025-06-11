package com.f2f.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginHistoryDTO {
    private Long id;
    private String clientId;
    private String username;
    private String ipAddress;
    private String device;
    private LocalDateTime loginTime;
    private Long userId; // فقط شناسه کاربر برای ساده سازی
    private boolean successful;
    private String failureReason;
}
