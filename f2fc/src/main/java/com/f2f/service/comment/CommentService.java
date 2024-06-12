package com.f2f.service.comment;

import com.f2f.dao.comment.CommentDTO;
import com.f2f.dao.comment.CommentDTOS;
import com.f2f.dao.comment.CommentDao;
import com.f2f.domain.UserAccount;
import com.f2f.entity.common.Comment;
import com.f2f.entity.common.CommentBenefits;
import com.f2f.entity.common.CommentTarget;
import com.f2f.entity.common.CommentUpsets;
import com.f2f.persistence.entity.UserAccountEntity;
import com.f2f.service.product.ProductService;
import com.github.dozermapper.core.Mapper;
//import com.f2f.domain.UserAccount;
import com.f2f.persistance.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@PreAuthorize("isAuthenticated()")
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private ProductService productService;

    @Autowired
    private CommentTargetService commentTargetService;

    @Autowired
    private CommentBenefitsService commentBenefitsService;

    @Autowired
    private CommentUpsetsService commentUpsetsService;

    @Autowired
    Mapper mapper;


    public CommentDTOS createComment(CommentDTOS commentDTO, CommentTarget commentTarget, UserAccount userAccount) {

        UserAccountEntity userAccountEntity = mapper.map(userAccount, UserAccountEntity.class);

        Comment comment = new Comment();

        List<CommentUpsets> upsets = new ArrayList<>();
        List<CommentBenefits> benefits = new ArrayList<>();

        //comment.setUpsets(commentDTO.getUpsets());
        //comment.setBenefits(commentDTO.getBenefits());
        //comment.setBenefits(benefits);
        //comment.setUpsets(upsets);

        comment.setBody(commentDTO.getContent());
        comment.setSubject(commentDTO.getTitle());
        comment.setCommentTarget(commentTarget);
        comment.setUserAccountEntity(userAccountEntity);
        commentDao.save(comment);

        for(String ben:commentDTO.getBenefits())
            commentBenefitsService.save(comment,ben);

        for(String up:commentDTO.getUpsets())
            commentUpsetsService.save(comment,up);

        return commentDTO;
    }

    public List<CommentDTO> getListOfCommentsForProductId(Long productId){

        Long commentTargetId=productService.findCommentTargetNo(productId);
        List<CommentDTO> commentList = commentTargetService.getListOfCommentsForTargetId(commentTargetId);
        return commentList;
    }
}
