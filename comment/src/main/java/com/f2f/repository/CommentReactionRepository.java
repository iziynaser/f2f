package com.f2f.repository;

import com.f2f.entity.CommentReaction;
import com.f2f.eums.CommentReactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentReactionRepository extends JpaRepository<CommentReaction, Long> {

    Optional<CommentReaction> findByCommentIdAndUserAccountIdAndReactionType(Long commentId, Long userAccountId, CommentReactionType reactionType);

    List<CommentReaction> findAllByCommentId(Long commentId);
}
