package com.f2f.dto;

import com.f2f.enums.QaStatus;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class QuestionAnswerDTO {
    private Long id;
    private String subject;
    private String body;
    private QaStatus status;
    private Long userAccountId;
    private Long parentId;
    private LocalDateTime createdAt;
    private List<QuestionAnswerDTO> children; // پاسخ‌ها (ساختار درختی)
    private long likeCount;
    private long dislikeCount;
}
