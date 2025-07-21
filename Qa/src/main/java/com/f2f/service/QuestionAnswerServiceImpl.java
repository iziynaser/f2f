package com.f2f.service;

import com.f2f.dto.QuestionAnswerDTO;
import com.f2f.dto.QuestionWithAnswerCount;
import com.f2f.entity.QaReaction;
import com.f2f.entity.QaTarget;
import com.f2f.entity.QuestionAnswer;
import com.f2f.enums.QaReactionType;
import com.f2f.enums.QaStatus;
import com.f2f.enums.QaTargetType;
import com.f2f.mapper.QuestionAnswerMapper;
import com.f2f.repository.QaReactionRepository;
import com.f2f.repository.QaTargetRepository;
import com.f2f.repository.QuestionAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public Page<QuestionAnswerDTO> getQuestionsLatestByTarget(String targetType, Long targetId, Pageable pageable) {
        // تبدیل امن String به Enum
        QaTargetType typeEnum;
        try {
            typeEnum = QaTargetType.valueOf(targetType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid target type: " + targetType);
        }

        // پیدا کردن Target مرتبط
        QaTarget target = qaTargetRepository
                .findByTargetTypeAndTargetId(typeEnum, targetId)
                .orElseThrow(() -> new RuntimeException("Target not found"));

        // محاسبه offset و limit
        int limit = pageable.getPageSize();
        int offset = (int) pageable.getOffset();

        // دریافت لیست سؤالات به همراه تعداد پاسخ
        List<QuestionWithAnswerCount> entities =
                questionAnswerRepository.findQuestionsWithAnswerCountNativeByTarget(target.getId(), limit, offset);

        // شمارش کل سؤالات تأییدشده برای تارگت
        long total = questionAnswerRepository.countQuestionsApprovedGroupedByTarget(target.getId());

        // تبدیل به DTO
        List<QuestionAnswerDTO> dtos = entities.stream()
                .map(item -> {
                    QuestionAnswerDTO dto = new QuestionAnswerDTO();
                    dto.setId(item.getId());
                    dto.setSubject(item.getSubject());
                    dto.setBody(item.getBody());
                    dto.setAnswerCount(item.getAnswerCount());
                    return dto;
                })
                .toList();

        return new PageImpl<>(dtos, pageable, total);
    }

    @Override
    public Page<QuestionAnswerDTO> getQuestionsByMostAnswersByTarget(String targetType, Long targetId, Pageable pageable) {
        // تبدیل امن به Enum
        QaTargetType typeEnum;
        try {
            typeEnum = QaTargetType.valueOf(targetType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid target type: " + targetType);
        }

        // یافتن تارگت
        QaTarget target = qaTargetRepository
                .findByTargetTypeAndTargetId(typeEnum, targetId)
                .orElseThrow(() -> new RuntimeException("Target not found"));

        // اگر بتوانید این مرتب‌سازی را به سطح دیتابیس منتقل کنید، بهتر است
        List<QuestionAnswer> sortedQuestions = questionAnswerRepository
                .findAllApprovedRootQuestionsByTarget(target).stream()
                .sorted((q1, q2) -> Integer.compare(
                        q2.getChildren() != null ? q2.getChildren().size() : 0,
                        q1.getChildren() != null ? q1.getChildren().size() : 0
                ))
                .toList();

        // صفحه‌بندی دستی
        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), sortedQuestions.size());

        if (start > end) {
            return new PageImpl<>(Collections.emptyList(), pageable, sortedQuestions.size());
        }

        List<QuestionAnswerDTO> pageContent = sortedQuestions.subList(start, end).stream()
                .map(this::mapWithReactions)
                .toList();

        return new PageImpl<>(pageContent, pageable, sortedQuestions.size());
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
            reaction.setQuestionAnswer(questionAnswerRepository.getReferenceById(questionAnswerId));
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

    private QuestionAnswerDTO mapWithReactions(QuestionAnswer entity) {
        QuestionAnswerDTO dto = mapper.toDto(entity);
        dto.setLikeCount(getReactionCount(entity.getId(), QaReactionType.LIKE));
        dto.setDislikeCount(getReactionCount(entity.getId(), QaReactionType.DISLIKE));
        if (entity.getChildren() != null && !entity.getChildren().isEmpty()) {
            dto.setChildren(entity.getChildren().stream()
                    .filter(c -> c.getStatus() == QaStatus.APPROVED)
                    .map(this::mapWithReactions)
                    .toList());
        }
        return dto;
    }
}
