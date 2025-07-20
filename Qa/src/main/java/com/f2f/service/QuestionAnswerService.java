package com.f2f.service;

import com.f2f.dto.QuestionAnswerDTO;
import com.f2f.enums.QaReactionType;
import com.f2f.enums.QaStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface QuestionAnswerService {

    Page<QuestionAnswerDTO> getQuestionsLatest(Pageable pageable);

    Page<QuestionAnswerDTO> getQuestionsByMostAnswers(Pageable pageable);

    List<QuestionAnswerDTO> getAnswersByQuestionId(Long questionId);

    QuestionAnswerDTO createQuestion(QuestionAnswerDTO questionAnswerDTO);

    QuestionAnswerDTO createAnswer(Long parentId, QuestionAnswerDTO answerDTO);

    QuestionAnswerDTO updateQuestionAnswer(QuestionAnswerDTO questionAnswerDTO);

    void deleteQuestionAnswer(Long id);

    long getReactionCount(Long questionAnswerId, QaReactionType reactionType);

    void reactToQuestionAnswer(Long questionAnswerId, Long userId, QaReactionType reactionType);

    QuestionAnswerDTO approveOrReject(Long id, QaStatus status);
}
