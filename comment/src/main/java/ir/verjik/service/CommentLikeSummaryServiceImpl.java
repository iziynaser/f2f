package ir.verjik.service;

import ir.verjik.dto.CommentLikeSummaryDTO;
import ir.verjik.enums.CommentReactionType;
import ir.verjik.repository.CommentReactionRepository;
import ir.verjik.repository.CommentTargetRepository;
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
