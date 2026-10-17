package ir.verjik.service;

import ir.verjik.dto.QuestionAnswerDTO;
import ir.verjik.enums.QaReactionType;
import ir.verjik.enums.QaStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionAnswerService {

    public Page<QuestionAnswerDTO> getQuestionsLatestByTarget(String targetType, Long targetId, Pageable pageable);

    public Page<QuestionAnswerDTO> getQuestionsByMostAnswersByTarget(String targetType, Long targetId, Pageable pageable);

    List<QuestionAnswerDTO> getAnswersByQuestionId(Long questionId);

    QuestionAnswerDTO createQuestion(QuestionAnswerDTO questionAnswerDTO);

    QuestionAnswerDTO createAnswer(Long parentId, QuestionAnswerDTO answerDTO);

    QuestionAnswerDTO updateQuestionAnswer(QuestionAnswerDTO questionAnswerDTO);

    void deleteQuestionAnswer(Long id);

    long getReactionCount(Long questionAnswerId, QaReactionType reactionType);

    void reactToQuestionAnswer(Long questionAnswerId, Long userId, QaReactionType reactionType);

    QuestionAnswerDTO approveOrReject(Long id, QaStatus status);
}
