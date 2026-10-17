package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;

 
import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "CONTENT_COMMENTS",
        uniqueConstraints = @UniqueConstraint(columnNames = {"CONTENT_ID","COMMENT_ID"}))
public class ContentComments extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "CONTENT_ID")
    private Content content;

//    @ManyToOne
//    @JoinColumn(name = "COMMENT_ID")
    @Column(name = "COMMENT_ID")
    private Long commentTargetId;

}
