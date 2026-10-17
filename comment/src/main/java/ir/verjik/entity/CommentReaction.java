package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import ir.verjik.enums.CommentReactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "COMMENT_REACTIONS",
        uniqueConstraints = @UniqueConstraint(columnNames = {"COMMENT_ID", "USER_ID", "REACTION_TYPE"}))
public class CommentReaction extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "COMMENT_ID", nullable = false)
    private Comment comment;

    @Column(name = "USER_ID", nullable = false)
    private Long userAccountId;

    @Enumerated(EnumType.STRING)
    @Column(name = "REACTION_TYPE", nullable = false)
    private CommentReactionType reactionType;
}
