package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.eums.CommentTargetType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(
        name = "COMMENT_TARGET",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"TARGET_TYPE", "TARGET_ID"})
        }
)
public class CommentTarget extends BaseEntity implements Serializable {

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "commentTarget")
    private List<Comment> comments;

    @Column(name = "TARGET_TYPE")
    @Enumerated(EnumType.STRING)
    private CommentTargetType targetType;

    @Column(name = "TARGET_ID", nullable = false)
    private Long targetId;

    public CommentTarget() {
            this.comments = new ArrayList<>();
        }
}
