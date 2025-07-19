package com.f2f.service.comment;

import com.f2f.dao.comment.CommentTargetDao;
import com.f2f.entity.Comment;
import com.f2f.entity.CommentTarget;
import com.f2f.dto.CommentLikeSummaryDTO;
import com.f2f.service.CommentLikeSummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentLikeSummaryServiceImpl  implements CommentLikeSummaryService {

    private final CommentTargetDao commentTargetRepository;

    public CommentLikeSummaryDTO getLikeSummaryByTargetId(Long targetId) {
        CommentTarget commentTarget = commentTargetRepository.findById(targetId)
                .orElseThrow(() -> new RuntimeException("CommentTarget not found"));

        int totalLikes = 0;
        int totalDislikes = 0;

        for (Comment comment : commentTarget.getComments()) {
//            CommentLikes likes = comment.getCommentLikes();
//            if (likes != null) {
//                totalLikes += likes.getNumberOfLikes();
//                totalDislikes += likes.getNumberOfDisLikes();
//            }
        }

        return new CommentLikeSummaryDTO(totalLikes, totalDislikes);
    }
}
