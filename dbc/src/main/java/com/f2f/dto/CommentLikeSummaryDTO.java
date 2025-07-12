package com.f2f.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentLikeSummaryDTO {
    private int totalLikes;
    private int totalDislikes;
}
