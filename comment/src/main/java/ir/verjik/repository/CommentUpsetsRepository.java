package ir.verjik.repository;

import ir.verjik.entity.CommentUpsets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentUpsetsRepository extends JpaRepository<CommentUpsets,Long> {
    List<CommentUpsets> findAllByCommentId(Long commentId);
}
