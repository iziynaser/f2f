package com.f2f.repository;

import com.f2f.entity.QaReaction;
import com.f2f.enums.QaReactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface QaReactionRepository extends JpaRepository<QaReaction, Long> {

    Optional<QaReaction> findByQuestionAnswerIdAndUserAccountIdAndReactionType(Long questionAnswerId, Long userAccountId, QaReactionType reactionType);

    long countByQuestionAnswerIdAndReactionType(Long questionAnswerId, QaReactionType reactionType);
}
