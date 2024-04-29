package com.f2f.dao.comment;

import com.f2f.entity.common.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CommentDao")
public interface CommentDao extends JpaRepository<Comment,Long> {

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
