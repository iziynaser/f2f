package com.f2f.dao.comment;

import com.f2f.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Repository("CommentDao")
public interface CommentDao extends JpaRepository<Comment,Long> {

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


//    @Query("select l.numberOfLikes,l.numberOfDisLikes,u.nickName,c.benefits,c.disadvatages,c.body,c.dateCreated,c.subject from Comment as c inner join UserAccountEntity as u on c.userAccountEntity = u left join CommentLikes as l on l.id = c.id")
//    public List<CommentDTO> getListOfComments();
//
//    @Query(nativeQuery = true,
//           value = "select\n" +
//               "        l.number_of_likes numberOfLikes,\n" +
//               "        l.number_of_dislikes numberOfDisLikes,\n" +
//               "        u.nick_name nickName,\n" +
//               "        c.benefits ,\n" +
//               "        c.disadvantages disadvatages,\n" +
//               "        c.body content,\n" +
//               "        c.date_created ,\n" +
//               "        c.subject\n" +
//               "from comment c\n" +
//               "inner join user_account_entity u on (c.user_account=u.id)\n" +
//               "left join comment_likes l on (l.id = c.id)\n"
//          )
//    public List<CommentDTO> getListOfCommentsNative();

}
