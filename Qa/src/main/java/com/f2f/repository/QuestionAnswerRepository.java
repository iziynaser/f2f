package com.f2f.repository;

import com.f2f.entity.QaTarget;
import com.f2f.entity.QuestionAnswer;
import com.f2f.enums.QaStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Long> {

    // پرسش‌های تایید شده (parent == null) مرتب شده بر اساس جدیدترین
    @Query(
            value = "SELECT q FROM QuestionAnswer q WHERE q.parent IS NULL AND q.status = 'APPROVED'",
            countQuery = "SELECT COUNT(q) FROM QuestionAnswer q WHERE q.parent IS NULL AND q.status = 'APPROVED'"
    )
    Page<QuestionAnswer> findLatestApprovedQuestions(Pageable pageable);


    // پرسش‌های تایید شده مرتب شده بر اساس تعداد پاسخ‌ها (بیشترین پاسخ)
    @Query(
            value = "SELECT q FROM QuestionAnswer q LEFT JOIN q.children c WHERE q.parent IS NULL AND q.status = 'APPROVED' GROUP BY q.id ORDER BY COUNT(c) DESC",
            countQuery = "SELECT COUNT(q) FROM QuestionAnswer q WHERE q.parent IS NULL AND q.status = 'APPROVED'"
    )
    Page<QuestionAnswer> findQuestionsOrderByMostAnswers(Pageable pageable);


    // پاسخ‌های یک پرسش (parent == پرسش مورد نظر) و تایید شده
    List<QuestionAnswer> findByParentIdAndStatus(Long parentId, QaStatus status);

    // همه سوالات و جواب‌های یک هدف خاص (qaTarget)
    List<QuestionAnswer> findByQaTargetAndStatus(QaTarget qaTarget, QaStatus status);
}
