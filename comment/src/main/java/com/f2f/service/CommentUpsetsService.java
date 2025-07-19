package com.f2f.service;

import com.f2f.entity.Comment;
import com.f2f.entity.CommentUpsets;
import com.f2f.repository.CommentUpsetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CommentUpsetsService {

    @Autowired
    CommentUpsetsRepository commentUpsetsRepository;

    public void save(Comment comment, String up) {
        CommentUpsets commentUpsets = new CommentUpsets(comment,up);
        commentUpsetsRepository.save(commentUpsets);
    }
}
