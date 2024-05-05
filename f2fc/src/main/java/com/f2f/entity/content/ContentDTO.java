package com.f2f.entity.content;

import java.util.ArrayList;
import java.util.List;

public class ContentDTO {

    private String Body ;

    private String code ;

    private String date;

    private String language ;

    private String status ;

    private String title ;

    private String name;

    private String description;

    private Short seq ;

    private Short ispublic;

    private int ContentType;

    private int purposeType;

    private String fromDate;

    private String toDate;

    private List<Tag> tags = new ArrayList<>();

    private List<Content> relatedContents = new ArrayList<>();

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

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Content> getRelatedContents() {
        return relatedContents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getSeq() {
        return seq;
    }

    public void setSeq(Short seq) {
        this.seq = seq;
    }

    public int getContentType() {
        return ContentType;
    }

    public void setContentType(int contentType) {
        ContentType = contentType;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPurposeType() {
        return purposeType;
    }

    public void setPurposeType(int purposeType) {
        this.purposeType = purposeType;
    }

    public Short getIspublic() {
        return ispublic;
    }

    public void setIspublic(Short ispublic) {
        this.ispublic = ispublic;
    }

    public void setRelatedContents(List<Content> relatedContents) {
        this.relatedContents = relatedContents;
    }
}
