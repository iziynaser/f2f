package com.f2f.entity.common;

import com.f2f.persistence.entity.BaseEntity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COMMENT_LIKES")
public class CommentLikes extends BaseEntity implements Serializable {

    @Column(name = "NUMBER_OF_LIKES")
    private int numberOfLikes ;

    @Column(name = "NUMBER_OF_DISLIKES")
    private int numberOfDisLikes ;

    @OneToOne
    @JoinColumn(name = "COMMENT_ID")
    private Comment comment;

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public int getNumberOfDisLikes() {
        return numberOfDisLikes;
    }

    public void setNumberOfDisLikes(int numberOfDisLikes) {
        this.numberOfDisLikes = numberOfDisLikes;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
