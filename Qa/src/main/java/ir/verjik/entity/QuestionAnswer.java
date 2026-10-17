package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import ir.verjik.enums.QaStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "QUESTION_ANSWER")
public class QuestionAnswer extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "QA_TARGET_ID")
    private QaTarget qaTarget;

    @Column(name = "SUBJECT")
    private String subject; // برای سوال، برای پاسخ می‌تواند nullable باشد

    @Column(name = "BODY", nullable = false)
    private String body;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private QaStatus status;

    private Long userAccountId;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private QuestionAnswer parent;  // پدر (null اگر سوال اصلی باشد)

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionAnswer> children = new ArrayList<>();

    @OneToMany(mappedBy = "questionAnswer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QaReaction> reactions = new ArrayList<>();

    // سازنده پیش‌فرض
    public QuestionAnswer() {}

}
