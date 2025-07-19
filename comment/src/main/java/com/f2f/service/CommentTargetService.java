package com.f2f.service;

import com.f2f.dto.CommentDTO;
import com.f2f.dto.CommentResponseDTO;
import com.f2f.entity.Comment;
import com.f2f.entity.CommentTarget;
import com.f2f.eums.CommentTargetType;
import com.f2f.mapper.CommentMapper;
import com.f2f.repository.CommentRepository;
import com.f2f.repository.CommentTargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentTargetService {

    private final CommentTargetRepository commentTargetRepository;

    private final CommentRepository commentRepository;

    private final CommentMapper commentMapper;

    public CommentTargetService(CommentTargetRepository commentTargetRepository, CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentTargetRepository = commentTargetRepository;
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }


    public CommentTarget returnNewCommentTarget(){
        CommentTarget commentTarget = commentTargetRepository.save(new CommentTarget());
        return commentTarget;
    }

    public List<CommentResponseDTO> getListOfCommentsForTargetId(Long commentTargetId) {
        List<Comment> commentList = commentRepository.findAllByCommentTargetId(commentTargetId);
        return commentMapper.toDtoList(commentList);
    }



    public Optional<CommentTarget> getCommentTargetForProduct(Long productId) {
        return commentTargetRepository.findByTargetTypeAndTargetId(CommentTargetType.PRODUCT, productId);
    }


}
