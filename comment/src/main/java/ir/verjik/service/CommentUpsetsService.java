package ir.verjik.service;

import ir.verjik.entity.Comment;
import ir.verjik.entity.CommentUpsets;
import ir.verjik.repository.CommentUpsetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
