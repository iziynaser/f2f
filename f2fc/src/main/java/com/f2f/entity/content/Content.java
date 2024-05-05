package com.f2f.entity.content;

import com.f2f.persistance.entity.BaseEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "_CONTENT")
public class Content extends BaseEntity implements Serializable {

    @Lob
    @Type(type="text")
    @Column(name = "BODY")
    private String Body ;

    @Column(name = "CODE")
    private String code ;

    @Column(name = "DATE")
    private String date;

    @Column(name = "LANGUAGE")
    private String language ;

    @Column(name="DESCRIPTION")
    private String description ;

    @Column(name = "TITLE")
    private String title ;

    @Column(name = "name")
    private String name;

    @Column(name = "seq",columnDefinition = "int default 0")
    private short seq;

    @OneToOne
    @JoinColumn(name = "ID")
    private ContentType contentType;

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

    public List<Content> getRelatedContents() {
        return relatedContents;
    }

    public void setRelatedContents(List<Content> relatedContents) {
        this.relatedContents = relatedContents;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLanguage() {
        return language;
    }

    public List<ContentStatus> getContentStatuses() {
        return contentStatuses;
    }

    public void setContentStatuses(List<ContentStatus> contentStatuses) {
        this.contentStatuses = contentStatuses;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public short getSeq() {
        return seq;
    }

    public void setSeq(short seq) {
        this.seq = seq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }
}
