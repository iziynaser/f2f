package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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
}
