package com.f2f.entity.qa;

import com.f2f.entity.common.Category;
import com.f2f.entity.product.Product;
import com.f2f.dbc.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "QA")
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
    private Category category ;

    @OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getBriefAnswer() {
        return briefAnswer;
    }

    public void setBriefAnswer(String briefAnswer) {
        this.briefAnswer = briefAnswer;
    }

    public String getAdditionalAnswer() {
        return additionalAnswer;
    }

    public void setAdditionalAnswer(String additionalAnswer) {
        this.additionalAnswer = additionalAnswer;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getReplyStatus() {
        return replyStatus;
    }

    public void setReplyStatus(String replyStatus) {
        this.replyStatus = replyStatus;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(String answerDate) {
        this.answerDate = answerDate;
    }

    public String getAnsweredBy() {
        return answeredBy;
    }

    public void setAnsweredBy(String answeredBy) {
        this.answeredBy = answeredBy;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
