package com.f2f.dao.comment;

import com.f2f.entity.common.CommentTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CommentTargetDao")
public interface CommentTargetDao extends JpaRepository<CommentTarget,Long> {

//    select
//    c.id,
//    c.body,
//    c.date_created,
//    c.subject,
//    uae.id,
//    uae.email,
//    uae.nick_name,
//    uae.gender,
//    cl.number_of_likes,
//    cl.number_of_dislikes ,
//    b.benefits,
//    u.upsets
//    from comment_target  t
//    inner join comment  c
//    on t.id = c.comment_target_id
//    inner join comment_benefits b
//    on b.comment_id = c.id
//    inner join comment_upsets u
//    on c.id = u.comment_id
//    inner join user_account_entity uae
//    on uae.id = c.user_account
//    left join comment_likes cl on c.id = cl.comment_id
//    where t.id = 7

//    @Query("select c from CommentTarget as t" +
//           "inner join Comment as c" +
//           "on c.commentTarget =t.id" +
//            "where t.id=:commentTargetId"
//    )


    //c.dateCreated as dateCreated,
//    @Query("select c.subject as subject,c.body as content,uae.nickName as nickName,cl.numberOfLikes as numberOfLikes,cl.numberOfDisLikes as numberOfDisLikes from CommentTarget as t inner join Comment as c on t.id = c.commentTarget inner join UserAccountEntity  as uae on uae.id = c.userAccountEntity left join CommentLikes as cl on c.id = cl.comment where t.id=:commentTargetId")
//    List<CommentDTO> getListOfCommentsByCommentTargetId(@Param("commentTargetId") Long  commentTargetId);

//    @Query("select c.subject as subject,c.body as content,uae.nickName as nickName,cl.numberOfLikes as numberOfLikes,cl.numberOfDisLikes as numberOfDisLikes " +
//            "from CommentTarget as t inner join Comment as c on t.id = c.commentTarget " +
//            "inner join comment_benefits as cb on c.id = cb.comment_id" +
//            "inner join UserAccountEntity  as uae on uae.id = c.userAccountEntity left join CommentLikes as cl on c.id = cl.comment where t.id=:commentTargetId")
//    List<CommentDTO> getListOfCommentsByCommentTargetId(@Param("commentTargetId") Long  commentTargetId);


    @Query(" select c.subject as subject,c.body as content,uae.nickName as nickName,cl.numberOfLikes as numberOfLikes,cl.numberOfDisLikes as numberOfDisLikes " +
            " ,cb.name as benefits,cu.name as disadvatages " +
            " from CommentTarget as t inner join Comment as c on t.id = c.commentTarget " +
            " inner join CommentBenefits as cb on cb.comment=c.id " +
            " inner join CommentUpsets as cu on cu.comment = c.id " +
            " inner join UserAccountEntity  as uae on uae.id = c.userAccountEntity left join CommentLikes as cl on c.id = cl.comment where t.id=:commentTargetId")
    List<CommentDTO> getListOfCommentsByCommentTargetId(@Param("commentTargetId") Long  commentTargetId);

}
