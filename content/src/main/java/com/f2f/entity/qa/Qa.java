package com.f2f.entity.qa;

import com.f2f.dbc.entity.BaseEntity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "QA")
@Setter
@Getter
public class Qa extends BaseEntity implements Serializable {

    @Column(name = "QUESTION")
    private String question;

    @Column(name = "BRIEF_ANSWER")
    private String briefAnswer ;

    @Column(name = "ADDITIONAL_ANSWER")
    private String additionalAnswer;

    @Column(name = "STATUS")
    private Short status ;

    @Column(name = "REPLY_STATUS")
    private String replyStatus ; //not reply , replye

    @Column(name = "CREATED_BY")
    private String createdBy ;

    @Column(name = "CREATED_DATE")
    private String createdDate;

    @Column(name = "ANSWERED_DATE")
    private String answerDate;

    @Column(name = "ANSWERED_BY")
    private String answeredBy ;

    @Column(name = "CATEGORY_ID")
    private Long categoryId ;

//    @OneToOne
//    @JoinColumn(name = "PRODUCT_ID")
    private Long productId;

}
