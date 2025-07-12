package com.f2f.controller.comment;

import com.f2f.dto.CommentLikeSummaryDTO;
import com.f2f.service.comment.CommentLikeSummaryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment-likes")
@RequiredArgsConstructor
public class CommentLikeSummaryController {

    private final CommentLikeSummaryServiceImpl commentLikeSummaryService;

    @GetMapping("/summary/{targetId}")
    public CommentLikeSummaryDTO getLikeSummary(@PathVariable Long targetId) {
        return commentLikeSummaryService.getLikeSummaryByTargetId(targetId);
    }
}
