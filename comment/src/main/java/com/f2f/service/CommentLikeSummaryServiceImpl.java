package com.f2f.service;

import com.f2f.entity.Comment;
import com.f2f.entity.CommentTarget;
import com.f2f.dto.CommentLikeSummaryDTO;
import com.f2f.eums.CommentReactionType;
import com.f2f.repository.CommentReactionRepository;
import com.f2f.repository.CommentTargetRepository;
import com.f2f.service.CommentLikeSummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentLikeSummaryServiceImpl implements CommentLikeSummaryService {

    private final CommentTargetRepository commentTargetRepository;
    private final CommentReactionRepository commentReactionRepository;

    @Override
    public CommentLikeSummaryDTO getLikeSummaryByTargetId(Long targetId) {
        List<Object[]> groupedCounts = commentReactionRepository.countReactionsGroupedByCommentAndType(targetId);

        int totalLikes = 0;
        int totalDislikes = 0;

        for (Object[] row : groupedCounts) {
            CommentReactionType type = (CommentReactionType) row[1];
            Long count = (Long) row[2];

            if (type == CommentReactionType.LIKE) {
                totalLikes += count.intValue();
            } else if (type == CommentReactionType.DISLIKE) {
                totalDislikes += count.intValue();
            }
        }

        return new CommentLikeSummaryDTO(totalLikes, totalDislikes);
    }
}
