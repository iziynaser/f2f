package com.f2f.service;

import com.f2f.dto.QuestionAnswerDTO;
import com.f2f.entity.QaReaction;
import com.f2f.entity.QuestionAnswer;
import com.f2f.enums.QaReactionType;
import com.f2f.enums.QaStatus;
import com.f2f.mapper.QuestionAnswerMapper;
import com.f2f.repository.QaReactionRepository;
import com.f2f.repository.QaTargetRepository;
import com.f2f.repository.QuestionAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QuestionAnswerServiceImpl implements QuestionAnswerService {

    @Autowired
    private QuestionAnswerRepository questionAnswerRepository;

    @Autowired
    private QaReactionRepository qaReactionRepository;

    @Autowired
    private QaTargetRepository qaTargetRepository;

    @Autowired
    private QuestionAnswerMapper mapper;

    @Override
    public Page<QuestionAnswerDTO> getQuestionsLatest(Pageable pageable) {
        Page<QuestionAnswer> page = questionAnswerRepository.findLatestApprovedQuestions(pageable);
        return page.map(entity -> mapWithReactions(entity));
    }

    @Override
    public Page<QuestionAnswerDTO> getQuestionsByMostAnswers(Pageable pageable) {
        Page<QuestionAnswer> page = questionAnswerRepository.findQuestionsOrderByMostAnswers(pageable);
        return page.map(entity -> mapWithReactions(entity));
    }

    @Override
    public List<QuestionAnswerDTO> getAnswersByQuestionId(Long questionId) {
        List<QuestionAnswer> answers = questionAnswerRepository.findByParentIdAndStatus(questionId, QaStatus.APPROVED);
        return answers.stream().map(this::mapWithReactions).toList();
    }

    @Override
    public QuestionAnswerDTO createQuestion(QuestionAnswerDTO questionAnswerDTO) {
        QuestionAnswer entity = mapper.toEntity(questionAnswerDTO);
        entity.setParent(null);
        entity.setStatus(QaStatus.PENDING);
        QuestionAnswer saved = questionAnswerRepository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public QuestionAnswerDTO createAnswer(Long parentId, QuestionAnswerDTO answerDTO) {
        QuestionAnswer answer = mapper.toEntity(answerDTO);
        QuestionAnswer parent = questionAnswerRepository.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Parent not found"));
        answer.setParent(parent);
        answer.setQaTarget(parent.getQaTarget());
        answer.setStatus(QaStatus.PENDING);
        QuestionAnswer saved = questionAnswerRepository.save(answer);
        return mapper.toDto(saved);
    }

    @Override
    public QuestionAnswerDTO updateQuestionAnswer(QuestionAnswerDTO questionAnswerDTO) {
        QuestionAnswer entity = mapper.toEntity(questionAnswerDTO);
        QuestionAnswer updated = questionAnswerRepository.save(entity);
        return mapper.toDto(updated);
    }

    @Override
    public void deleteQuestionAnswer(Long id) {
        questionAnswerRepository.deleteById(id);
    }

    @Override
    public long getReactionCount(Long questionAnswerId, QaReactionType reactionType) {
        return qaReactionRepository.countByQuestionAnswerIdAndReactionType(questionAnswerId, reactionType);
    }

    @Override
    public void reactToQuestionAnswer(Long questionAnswerId, Long userId, QaReactionType reactionType) {
        Optional<QaReaction> existing = qaReactionRepository.findByQuestionAnswerIdAndUserAccountIdAndReactionType(
                questionAnswerId, userId, reactionType);
        if (existing.isPresent()) {
            qaReactionRepository.delete(existing.get());
        } else {
            QaReaction reaction = new QaReaction();
            reaction.setQuestionAnswer(questionAnswerRepository.getOne(questionAnswerId));
            reaction.setUserAccountId(userId);
            reaction.setReactionType(reactionType);
            qaReactionRepository.save(reaction);
        }
    }

    @Override
    public QuestionAnswerDTO approveOrReject(Long id, QaStatus status) {
        QuestionAnswer questionAnswer = questionAnswerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question/Answer not found"));
        questionAnswer.setStatus(status);
        QuestionAnswer saved = questionAnswerRepository.save(questionAnswer);
        return mapper.toDto(saved);
    }

    // کمک کننده برای map کردن و افزودن تعداد لایک و دیسلایک
    private QuestionAnswerDTO mapWithReactions(QuestionAnswer entity) {
        QuestionAnswerDTO dto = mapper.toDto(entity);
        dto.setLikeCount(getReactionCount(entity.getId(), QaReactionType.LIKE));
        dto.setDislikeCount(getReactionCount(entity.getId(), QaReactionType.DISLIKE));
        // در صورت نیاز children را هم map کن
        if (entity.getChildren() != null && !entity.getChildren().isEmpty()) {
            dto.setChildren(entity.getChildren().stream()
                    .filter(c -> c.getStatus() == QaStatus.APPROVED)
                    .map(this::mapWithReactions)
                    .toList());
        }
        return dto;
    }
}
