package com.f2f.service;

import com.f2f.dto.CommentDTO;
import com.f2f.dto.CommentResponseDTO;
import com.f2f.entity.Comment;
import com.f2f.entity.CommentTarget;
import com.f2f.eums.CommentSortType;
import com.f2f.mapper.CommentMapper;
//import org.springframework.security.access.prepost.PreAuthorize;
import com.f2f.repository.CommentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentMapper commentMapper ;

    private final CommentRepository commentRepository;

    private final CommentTargetService commentTargetService;

    private final CommentBenefitsService commentBenefitsService;

    private final CommentUpsetsService commentUpsetsService;

    public CommentService(CommentUpsetsService commentUpsetsService,
                          CommentBenefitsService commentBenefitsService,
                          CommentTargetService commentTargetService,
                          CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentUpsetsService = commentUpsetsService;
        this.commentBenefitsService = commentBenefitsService;
        this.commentTargetService = commentTargetService;
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    public List<CommentResponseDTO> getComments(CommentSortType sortType) {
        List<Comment> comments;

        switch (sortType) {
            case CREATED_ORDER -> comments = commentRepository.findAllCreatedOrder();
            case MOST_BENEFIT -> comments = commentRepository.findAllOrderByBenefitCountDesc();
            case MOST_UPSET -> comments = commentRepository.findAllOrderByUpsetCountDesc();
            case NEWEST -> comments = commentRepository.findAllOrderByNewest();
            case OLDEST -> comments = commentRepository.findAllOrderByOldest();
            default -> comments = commentRepository.findAll();
        }

        return commentMapper.toDtoList(comments);
    }

    public List<CommentResponseDTO> getListOfCommentsForProductId(Long productId) {
        Optional<CommentTarget> targetOpt = commentTargetService.getCommentTargetForProduct(productId);

        if (targetOpt.isEmpty()) {
            return List.of(); // یا throw exception
        }

        List<Comment> comments = commentRepository.findAllByCommentTargetId(targetOpt.get().getId());
        return commentMapper.toDtoList(comments); // خروجی List<CommentResponseDTO>
    }


}
