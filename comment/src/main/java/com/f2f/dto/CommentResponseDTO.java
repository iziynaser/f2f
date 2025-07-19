package com.f2f.dto;

import java.util.List;

import lombok.Data;

@Data
public class CommentResponseDTO {

    private Long id;
    private String subject;
    private String body;
    private String status;
    private Long userAccountId;

    private List<String> benefits;
    private List<String> upsets;

    // واکنش‌ها به صورت تعداد کلی بر اساس نوع
    private Double rating; // مثل 4.8
    private int totalReactions;
    private List<ReactionCountDTO> reactionSummary;
}
