package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.enums.QaTargetType;
import jakarta.persistence.*;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(
        name = "QA_TARGET",
        uniqueConstraints = @UniqueConstraint(columnNames = {"TARGET_TYPE", "TARGET_ID"})
)
public class QaTarget extends BaseEntity implements Serializable {

    @OneToMany(mappedBy = "qaTarget", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionAnswer> questionAnswers = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "TARGET_TYPE")
    private QaTargetType targetType;

    @Column(name = "TARGET_ID", nullable = false)
    private Long targetId;

    public QaTarget() {}
}
