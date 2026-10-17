package ir.verjik.service;

import ir.verjik.entity.Comment;
import ir.verjik.entity.CommentBenefits;
import ir.verjik.repository.CommentBenefitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
