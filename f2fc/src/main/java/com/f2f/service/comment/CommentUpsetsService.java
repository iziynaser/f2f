package com.f2f.service.comment;

import com.f2f.dao.comment.CommentUpsetsDao;
import com.f2f.entity.common.Comment;
import com.f2f.entity.common.CommentUpsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentUpsetsService {

    @Autowired
    CommentUpsetsDao commentUpsetsDao;

    public void save(Comment comment, String up) {
        CommentUpsets commentUpsets = new CommentUpsets(comment,up);
        commentUpsetsDao.save(commentUpsets);
    }
}
