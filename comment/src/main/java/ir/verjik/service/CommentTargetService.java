package ir.verjik.service;

import ir.verjik.dto.CommentResponseDTO;
import ir.verjik.entity.Comment;
import ir.verjik.entity.CommentTarget;
import ir.verjik.enums.CommentTargetType;
import ir.verjik.mapper.CommentMapper;
import ir.verjik.repository.CommentRepository;
import ir.verjik.repository.CommentTargetRepository;
import org.springframework.stereotype.Service;

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
