package ir.verjik.controller;

import ir.verjik.dto.CommentLikeSummaryDTO;
import ir.verjik.service.CommentLikeSummaryServiceImpl;
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
