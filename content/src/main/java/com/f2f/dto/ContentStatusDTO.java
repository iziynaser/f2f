package com.f2f.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentStatusDTO {
    private Long id;
    private Long contentId;
    private String status; // یا Enum ContentStatusType
    private LocalDateTime modifyDate;
    private String modifiedBy;
}
