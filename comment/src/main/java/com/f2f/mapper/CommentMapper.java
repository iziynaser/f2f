package com.f2f.mapper;

import com.f2f.dto.CommentResponseDTO;
import com.f2f.entity.Comment;
import com.f2f.entity.CommentBenefits;
import com.f2f.entity.CommentUpsets;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "benefits", expression = "java(mapBenefits(comment))")
    @Mapping(target = "upsets", expression = "java(mapUpsets(comment))")
    CommentResponseDTO toDto(Comment comment);

    List<CommentResponseDTO> toDtoList(List<Comment> comments);

    // Default method برای benefits
    default List<String> mapBenefits(Comment comment) {
        if (comment.getBenefits() == null) return List.of();
        return comment.getBenefits().stream()
                .map(CommentBenefits::getName)
                .collect(Collectors.toList());
    }

    // Default method برای upsets
    default List<String> mapUpsets(Comment comment) {
        if (comment.getUpsets() == null) return List.of();
        return comment.getUpsets().stream()
                .map(CommentUpsets::getName)
                .collect(Collectors.toList());
    }
}
