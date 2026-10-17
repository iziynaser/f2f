package ir.verjik.mapper;

import ir.verjik.dto.CommentResponseDTO;
import ir.verjik.dto.ReactionCountDTO;
import ir.verjik.entity.Comment;
import ir.verjik.entity.CommentBenefits;
import ir.verjik.entity.CommentUpsets;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

import java.util.*;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "benefits", expression = "java(mapBenefits(comment))")
    @Mapping(target = "upsets", expression = "java(mapUpsets(comment))")
    @Mapping(target = "reactionSummary", expression = "java(mapReactionSummary(comment))")
    @Mapping(target = "rating", expression = "java(calculateRating(comment))")
    @Mapping(target = "totalReactions", expression = "java(comment.getReactions() != null ? comment.getReactions().size() : 0)")
    CommentResponseDTO toDto(Comment comment);

    List<CommentResponseDTO> toDtoList(List<Comment> comments);

    default List<String> mapBenefits(Comment comment) {
        if (comment.getBenefits() == null) return List.of();
        return comment.getBenefits().stream()
                .map(CommentBenefits::getName)
                .collect(Collectors.toList());
    }

    default List<String> mapUpsets(Comment comment) {
        if (comment.getUpsets() == null) return List.of();
        return comment.getUpsets().stream()
                .map(CommentUpsets::getName)
                .collect(Collectors.toList());
    }

    default List<ReactionCountDTO> mapReactionSummary(Comment comment) {
        if (comment.getReactions() == null) return List.of();

        Map<String, Long> reactionCountMap = comment.getReactions().stream()
                .collect(Collectors.groupingBy(
                        r -> r.getReactionType().name(),
                        Collectors.counting()
                ));

        return reactionCountMap.entrySet().stream()
                .map(entry -> new ReactionCountDTO(entry.getKey(), entry.getValue().intValue()))
                .collect(Collectors.toList());
    }

    default Double calculateRating(Comment comment) {
        if (comment.getReactions() == null || comment.getReactions().isEmpty()) return 0.0;

        // امتیاز دهی ساده: به هر واکنش یک وزن بدیم
        Map<String, Double> weights = Map.of(
                "HELPFUL", 1.0,
                "FUNNY", 0.5,
                "INFORMATIVE", 1.2
        );

        double totalScore = comment.getReactions().stream()
                .mapToDouble(r -> weights.getOrDefault(r.getReactionType().name(), 0.0))
                .sum();

        double rating = totalScore / comment.getReactions().size();
        return Math.round(rating * 10.0) / 10.0; // مثلاً 4.8
    }
}
