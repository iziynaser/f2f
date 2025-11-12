package com.f2f.controller;

import com.f2f.dto.CommentLikeSummaryDTO;
import com.f2f.service.CommentLikeSummaryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment-likes")
@RequiredArgsConstructor
public class CommentLikeSummaryController {

    private final CommentLikeSummaryServiceImpl commentLikeSummaryService;

    @GetMapping("/summary/{targetId}")
    public CommentLikeSummaryDTO getLikeSummary(@PathVariable Long targetId) {
        return commentLikeSummaryService.getLikeSummaryByTargetId(targetId);
    }
}
