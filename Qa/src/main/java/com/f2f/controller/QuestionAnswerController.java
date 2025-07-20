package com.f2f.controller;

import com.f2f.dto.QuestionAnswerDTO;
import com.f2f.enums.QaReactionType;
import com.f2f.enums.QaStatus;
import com.f2f.service.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/qas")
public class QuestionAnswerController {

    @Autowired
    private QuestionAnswerService questionAnswerService;

    // گرفتن پرسش‌ها جدیدترین صفحه‌ای
    @GetMapping("/questions/latest")
    public ResponseEntity<Page<QuestionAnswerDTO>> getLatestQuestions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<QuestionAnswerDTO> questions = questionAnswerService.getQuestionsLatest(PageRequest.of(page, size));
        return ResponseEntity.ok(questions);
    }

    // گرفتن پرسش‌ها بر اساس بیشترین پاسخ
    @GetMapping("/questions/most-answers")
    public ResponseEntity<Page<QuestionAnswerDTO>> getQuestionsByMostAnswers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<QuestionAnswerDTO> questions = questionAnswerService.getQuestionsByMostAnswers(PageRequest.of(page, size));
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
