package com.f2f.repository;

import com.f2f.dto.QuestionWithAnswerCount;
import com.f2f.entity.QaTarget;
import com.f2f.entity.QuestionAnswer;
import com.f2f.enums.QaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer, Long> {

    @Query(value = """
        SELECT 
            q.id AS id,
            q.subject AS subject,
            q.body AS body,
            COUNT(c.id) AS answerCount
        FROM 
            question_answer q
        LEFT JOIN 
            question_answer c ON q.id = c.parent_id
        WHERE 
            q.parent_id IS NULL 
            AND q.status = 'APPROVED'
            AND q.qa_target_id = :targetId
        GROUP BY 
            q.id, q.subject, q.body
        ORDER BY 
            answerCount DESC
        LIMIT :limit OFFSET :offset
        """, nativeQuery = true)
    List<QuestionWithAnswerCount> findQuestionsWithAnswerCountNativeByTarget(
            @Param("targetId") Long targetId,
            @Param("limit") int limit,
            @Param("offset") int offset
    );

    @Query(value = """
        SELECT COUNT(*) FROM (
            SELECT q.id
            FROM question_answer q
            WHERE q.parent_id IS NULL 
              AND q.status = 'APPROVED'
              AND q.qa_target_id = :targetId
            GROUP BY q.id
        ) AS grouped
        """, nativeQuery = true)
    long countQuestionsApprovedGroupedByTarget(@Param("targetId") Long targetId);

    @Query("SELECT q FROM QuestionAnswer q WHERE q.parent IS NULL AND q.status = 'APPROVED' AND q.qaTarget = :target")
    List<QuestionAnswer> findAllApprovedRootQuestionsByTarget(@Param("target") QaTarget target);

    List<QuestionAnswer> findByParentIdAndStatus(Long parentId, QaStatus status);
}
