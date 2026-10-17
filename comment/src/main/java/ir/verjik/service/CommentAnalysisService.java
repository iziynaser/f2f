package ir.verjik.service;

import ir.verjik.enums.CommentReactionType;
import ir.verjik.enums.CommentTargetType;
import ir.verjik.repository.CommentReactionRepository;
import ir.verjik.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CommentAnalysisService {

    private final CommentRepository commentRepository;
    private final CommentReactionRepository commentReactionRepository;

    public Long countCommentsForProduct(Long productId) {
        return commentRepository.countApprovedCommentsByTarget(CommentTargetType.PRODUCT, productId);
    }

    public Double calculateRatingForProduct(Long productId) {
        List<Object[]> grouped = commentReactionRepository.countReactionsGroupedByType(CommentTargetType.PRODUCT, productId);
        Map<CommentReactionType, Long> counts = new EnumMap<>(CommentReactionType.class);

        for (Object[] row : grouped) {
            CommentReactionType type = (CommentReactionType) row[0];
            Long count = (Long) row[1];
            counts.put(type, count);
        }

        // سیستم امتیازدهی (به‌صورت نمونه):
        // LIKE → 5, LAUGH → 4, DISLIKE → 2, ANGRY → 1
        long totalScore = 0;
        long totalCount = 0;

        for (Map.Entry<CommentReactionType, Long> entry : counts.entrySet()) {
            int score = switch (entry.getKey()) {
                case LIKE -> 5;
                case LAUGH -> 4;
                case DISLIKE -> 2;
                case ANGRY -> 0;
                default -> 1; // یا امتیاز پیش‌فرض
            };
            totalScore += score * entry.getValue();
            totalCount += entry.getValue();
        }

        return totalCount == 0 ? null : (double) totalScore / totalCount;
    }
}
