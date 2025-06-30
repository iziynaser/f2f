package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

}
