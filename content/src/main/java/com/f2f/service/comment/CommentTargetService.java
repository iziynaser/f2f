package com.f2f.service.comment;

import com.f2f.dao.comment.CommentTargetDao;
import com.f2f.dto.CommentDTO;
import com.f2f.entity.CommentTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommentTargetService {

    @Autowired
    private CommentTargetDao commentTargetDao;

    public CommentTarget returnNewCommentTarget(){
        CommentTarget commentTarget = commentTargetDao.save(new CommentTarget());
        return commentTarget;
    }

    public List<CommentDTO> getListOfCommentsForTargetId(Long commentTargetId){
        //List<Comment> commentList = commentTargetDao.getOne(commentTargetId).getComments();
        //return commentList;
        List<CommentDTO> commentList = new ArrayList<>();//commentTargetDao.getListOfCommentsByCommentTargetId(commentTargetId);
        return commentList;
    }

}
