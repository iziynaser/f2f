package com.f2f.service;

import com.f2f.entity.Comment;
import com.f2f.entity.CommentBenefits;
import com.f2f.repository.CommentBenefitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CommentBenefitsService {

    @Autowired
    CommentBenefitsRepository commentBenefitsRepository;

    public void save(Comment comment, String ben) {
        CommentBenefits commentBenefits = new CommentBenefits(comment,ben);
        commentBenefitsRepository.save(commentBenefits);
    }
}
