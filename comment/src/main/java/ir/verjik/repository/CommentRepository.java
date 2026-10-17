package ir.verjik.repository;

import ir.verjik.entity.Comment;
import ir.verjik.enums.CommentStatus;
import ir.verjik.enums.CommentTargetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Repository("CommentDao")
public interface CommentRepository extends JpaRepository<Comment,Long> {

    // الف - ترتیب اولیه ایجاد (مثلاً بدون مرتب‌سازی خاص)
    @Query("SELECT c FROM Comment c")
    List<Comment> findAllCreatedOrder();

    // ب - بیشترین مزایا
    @Query("""
    SELECT c FROM Comment c
    LEFT JOIN c.benefits b
    GROUP BY c
    ORDER BY COUNT(b) DESC
""")
    List<Comment> findAllOrderByBenefitCountDesc();

    // ج - بیشترین معایب
    @Query("""
    SELECT c FROM Comment c
    LEFT JOIN c.upsets u
    GROUP BY c
    ORDER BY COUNT(u) DESC
""")
    List<Comment> findAllOrderByUpsetCountDesc();

    // د - جدیدترین
    @Query("SELECT c FROM Comment c ORDER BY c.id DESC")
    List<Comment> findAllOrderByNewest();

    // ه - قدیمی‌ترین
    @Query("SELECT c FROM Comment c ORDER BY c.id ASC")
    List<Comment> findAllOrderByOldest();

    List<Comment> findAllByCommentTargetId(Long commentTargetId);

    List<Comment> findAllByCommentTargetIdAndStatus(Long commentTargetId, CommentStatus status);

    @Query("""
        SELECT cr.comment.id, cr.reactionType, COUNT(cr)
        FROM CommentReaction cr
        WHERE cr.comment.commentTarget.id = :targetId
        GROUP BY cr.comment.id, cr.reactionType
    """)
    List<Object[]> countReactionsGroupedByCommentAndType(@Param("targetId") Long targetId);

    @Query("SELECT COUNT(c.id) FROM Comment c WHERE c.commentTarget.targetType = :type AND c.commentTarget.targetId = :targetId AND c.status = 'APPROVED'")
    Long countApprovedCommentsByTarget(@Param("type") CommentTargetType type, @Param("targetId") Long targetId);


}
