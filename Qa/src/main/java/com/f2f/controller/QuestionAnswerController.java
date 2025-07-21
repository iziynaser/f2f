package com.f2f.controller;

import com.f2f.dto.QuestionAnswerDTO;
import com.f2f.enums.QaReactionType;
import com.f2f.enums.QaStatus;
import com.f2f.service.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/f2f/qas")
public class QuestionAnswerController {

    @Autowired
    private QuestionAnswerService questionAnswerService;

    @GetMapping("/questions/latest/{targetType}/{targetId}")
    public ResponseEntity<Page<QuestionAnswerDTO>> getLatestQuestions(
            @PathVariable String targetType,
            @PathVariable Long targetId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<QuestionAnswerDTO> questions = questionAnswerService.getQuestionsLatestByTarget(targetType, targetId, pageable);

        return ResponseEntity.ok(questions);
    }

    @GetMapping("/questions/most-answers/{targetType}/{targetId}")
    public ResponseEntity<Page<QuestionAnswerDTO>> getQuestionsByMostAnswers(
            @PathVariable String targetType,
            @PathVariable Long targetId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<QuestionAnswerDTO> questions = questionAnswerService.getQuestionsByMostAnswersByTarget(targetType, targetId, pageable);

        return ResponseEntity.ok(questions);
    }

    // گرفتن پاسخ‌های یک پرسش
    @GetMapping("/questions/{id}/answers")
    public ResponseEntity<List<QuestionAnswerDTO>> getAnswersByQuestionId(@PathVariable Long id) {
        List<QuestionAnswerDTO> answers = questionAnswerService.getAnswersByQuestionId(id);
        return ResponseEntity.ok(answers);
    }

    // ایجاد پرسش جدید
    @PostMapping("/questions")
    public ResponseEntity<QuestionAnswerDTO> createQuestion(@RequestBody QuestionAnswerDTO dto) {
        QuestionAnswerDTO created = questionAnswerService.createQuestion(dto);
        return ResponseEntity.ok(created);
    }

    // ایجاد پاسخ به یک پرسش یا پاسخ
    @PostMapping("/{parentId}/answers")
    public ResponseEntity<QuestionAnswerDTO> createAnswer(@PathVariable Long parentId, @RequestBody QuestionAnswerDTO dto) {
        QuestionAnswerDTO created = questionAnswerService.createAnswer(parentId, dto);
        return ResponseEntity.ok(created);
    }

    // ویرایش پرسش یا پاسخ
    @PutMapping("/{id}")
    public ResponseEntity<QuestionAnswerDTO> updateQuestionAnswer(@PathVariable Long id, @RequestBody QuestionAnswerDTO dto) {
        dto.setId(id);
        QuestionAnswerDTO updated = questionAnswerService.updateQuestionAnswer(dto);
        return ResponseEntity.ok(updated);
    }

    // حذف پرسش یا پاسخ
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestionAnswer(@PathVariable Long id) {
        questionAnswerService.deleteQuestionAnswer(id);
        return ResponseEntity.noContent().build();
    }

    // ثبت واکنش (مفید/غیرمفید)
    @PostMapping("/{id}/react")
    public ResponseEntity<Void> reactToQuestionAnswer(
            @PathVariable Long id,
            @RequestParam Long userId,
            @RequestParam QaReactionType reactionType) {
        questionAnswerService.reactToQuestionAnswer(id, userId, reactionType);
        return ResponseEntity.ok().build();
    }

    // تایید یا رد پرسش یا پاسخ توسط مدیر
    @PostMapping("/{id}/approve")
    public ResponseEntity<QuestionAnswerDTO> approveOrReject(
            @PathVariable Long id,
            @RequestParam QaStatus status) {
        QuestionAnswerDTO updated = questionAnswerService.approveOrReject(id, status);
        return ResponseEntity.ok(updated);
    }
}
