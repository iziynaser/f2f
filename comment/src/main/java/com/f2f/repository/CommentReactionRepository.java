package com.f2f.repository;

import com.f2f.entity.CommentReaction;
import com.f2f.eums.CommentReactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommentReactionRepository extends JpaRepository<CommentReaction, Long> {

    Optional<CommentReaction> findByCommentIdAndUserAccountIdAndReactionType(Long commentId, Long userAccountId, CommentReactionType reactionType);

    List<CommentReaction> findAllByCommentId(Long commentId);

    @Query("""
        SELECT cr.comment.id, cr.reactionType, COUNT(cr)
        FROM CommentReaction cr
        WHERE cr.comment.commentTarget.id = :targetId
        GROUP BY cr.comment.id, cr.reactionType
        """)
    List<Object[]> countReactionsGroupedByCommentAndType(@Param("targetId") Long targetId);


}
