package com.f2f.service.comment;

import com.f2f.dao.comment.CommentBenefitsDao;
import com.f2f.entity.common.Comment;
import com.f2f.entity.common.CommentBenefits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentBenefitsService {

    @Autowired
    CommentBenefitsDao commentBenefitsDao;

    public void save(Comment comment, String ben) {
        CommentBenefits commentBenefits = new CommentBenefits(comment,ben);
        commentBenefitsDao.save(commentBenefits);
    }
}
