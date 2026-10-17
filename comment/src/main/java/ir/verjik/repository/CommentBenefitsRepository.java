package ir.verjik.repository;

import ir.verjik.entity.CommentBenefits;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentBenefitsRepository extends JpaRepository<CommentBenefits,Long> {
    List<CommentBenefits> findAllByCommentId(Long commentId);
}
