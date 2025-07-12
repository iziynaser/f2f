package com.f2f.service.comment;

import com.f2f.dao.comment.CommentDao;
import com.f2f.dto.CommentDTO;
import com.f2f.dto.CommentResponseDTO;
import com.f2f.entity.Comment;
import com.f2f.eums.CommentSortType;
import com.f2f.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommentService {

    private final CommentMapper commentMapper ;

    private final CommentDao commentDao;

    private final CommentTargetService commentTargetService;

    private final CommentBenefitsService commentBenefitsService;

    private final CommentUpsetsService commentUpsetsService;

    public CommentService(CommentUpsetsService commentUpsetsService,
                          CommentBenefitsService commentBenefitsService,
                          CommentTargetService commentTargetService,
                          CommentDao commentDao,CommentMapper commentMapper) {
        this.commentUpsetsService = commentUpsetsService;
        this.commentBenefitsService = commentBenefitsService;
        this.commentTargetService = commentTargetService;
        this.commentDao = commentDao;
        this.commentMapper = commentMapper;
    }

    public List<CommentResponseDTO> getComments(CommentSortType sortType) {
        List<Comment> comments;

        switch (sortType) {
            case CREATED_ORDER -> comments = commentDao.findAllCreatedOrder();
            case MOST_BENEFIT -> comments = commentDao.findAllOrderByBenefitCountDesc();
            case MOST_UPSET -> comments = commentDao.findAllOrderByUpsetCountDesc();
            case NEWEST -> comments = commentDao.findAllOrderByNewest();
            case OLDEST -> comments = commentDao.findAllOrderByOldest();
            default -> comments = commentDao.findAll();
        }

        return commentMapper.toDtoList(comments);
    }


//
//    public CommentDTOS createComment(CommentDTOS commentDTO, CommentTarget commentTarget, UserAccount userAccount) {
//
//        //UserAccountEntity userAccountEntity = mapper.map(userAccount, UserAccountEntity.class);
//        UserAccountEntity userAccountEntity = copy(userAccount);
//
//        Comment comment = new Comment();
//
//        List<CommentUpsets> upsets = new ArrayList<>();
//        List<CommentBenefits> benefits = new ArrayList<>();
//
//        //comment.setUpsets(commentDTO.getUpsets());
//        //comment.setBenefits(commentDTO.getBenefits());
//        //comment.setBenefits(benefits);
//        //comment.setUpsets(upsets);
//
//        comment.setBody(commentDTO.getContent());
//        comment.setSubject(commentDTO.getTitle());
//        comment.setCommentTarget(commentTarget);
//        comment.setUserAccountEntity(userAccountEntity);
//        commentDao.save(comment);
//
//        for(String ben:commentDTO.getBenefits())
//            commentBenefitsService.save(comment,ben);
//
//        for(String up:commentDTO.getUpsets())
//            commentUpsetsService.save(comment,up);
//
//        return commentDTO;
//    }


    public List<CommentDTO> getListOfCommentsForProductId(Long productId){
        return null;
    }
}
