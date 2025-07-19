package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommentResponseDTO {
    private String subject;
    private String body;
    private String status;
    private Long userAccountId;

    private int numberOfLikes;
    private int numberOfDisLikes;

    private List<String> benefits;
    private List<String> upsets;
}
