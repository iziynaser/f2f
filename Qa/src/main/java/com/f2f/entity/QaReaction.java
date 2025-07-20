package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.enums.QaReactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(
        name = "QA_REACTIONS",
        uniqueConstraints = @UniqueConstraint(columnNames = {"QUESTION_ANSWER_ID", "USER_ID", "REACTION_TYPE"})
)
public class QaReaction extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "QUESTION_ANSWER_ID", nullable = false)
    private QuestionAnswer questionAnswer;

    @Column(name = "USER_ID", nullable = false)
    private Long userAccountId;

    @Enumerated(EnumType.STRING)
    @Column(name = "REACTION_TYPE", nullable = false)
    private QaReactionType reactionType;

}
