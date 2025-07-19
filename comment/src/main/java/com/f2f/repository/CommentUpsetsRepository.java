package com.f2f.repository;

import com.f2f.entity.CommentUpsets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentUpsetsRepository extends JpaRepository<CommentUpsets,Long> {
    List<CommentUpsets> findAllByCommentId(Long commentId);
}
