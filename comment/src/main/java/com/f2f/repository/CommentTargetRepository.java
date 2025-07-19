package com.f2f.repository;

import com.f2f.entity.Comment;
import com.f2f.entity.CommentTarget;
import com.f2f.eums.CommentStatus;
import com.f2f.eums.CommentTargetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CommentTargetRepository extends JpaRepository<CommentTarget, Long> {

    @Query("SELECT ct FROM CommentTarget ct WHERE ct.targetType = :type")
    List<CommentTarget> findAllByTargetType(@Param("type") CommentTargetType type);

    Optional<CommentTarget> findByTargetTypeAndTargetId(CommentTargetType targetType, Long targetId);

    @Query("SELECT COUNT(c.id) FROM Comment c WHERE c.commentTarget.targetType = :type AND c.commentTarget.targetId = :targetId AND c.status = 'APPROVED'")
    Long countApprovedCommentsByTarget(@Param("type") CommentTargetType type, @Param("targetId") Long targetId);

}
