package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import ir.verjik.eums.ContentTargetType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "_CONTENT")
public class Content extends BaseEntity implements Serializable {

    @Lob
    @Column(name = "BODY")
    private String body ;

    @Column(name = "CODE")
    private String code ;

    @Column(name = "DATE")
    private LocalDateTime date;

    @Column(name = "LANGUAGE")
    private String language ;

    @Column(name="DESCRIPTION")
    private String description ;

    @Column(name = "TITLE")
    private String title ;

    @Column(name = "SLUG", unique = true)
    private String slug;

    @Column(name = "seq",columnDefinition = "int default 0")
    private short seq;

    @ManyToOne
    @JoinColumn(name = "CONTENT_TYPE_ID") // بهتر از ID خالیه
    private ContentType contentType;

    @Enumerated(EnumType.STRING)
    @Column(name = "TARGET_TYPE")
    private ContentTargetType targetType;

    @Column(name = "TARGET_ID")
    private Long targetId;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "CONTENT_TAG" ,
            joinColumns = @JoinColumn(name = "CONTENT_ID") ,
            inverseJoinColumns = @JoinColumn(name = "TAG_ID")
    )
    private List<Tag> tags = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "CONTENT_RELATED_CONTENT" ,
            joinColumns = {@JoinColumn(name = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "RELATED_CONTENT_ID")})
    private List<Content> relatedContents = new ArrayList<>();


    @OneToMany(mappedBy = "content")
    private List<ContentStatus> contentStatuses;

    public Content(Long id) {
        this.setId(id);
    }


}
