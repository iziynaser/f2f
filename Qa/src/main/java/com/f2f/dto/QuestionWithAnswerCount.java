package com.f2f.dto;

public interface QuestionWithAnswerCount {
    Long getId();
    String getSubject();
    String getBody();
    Long getAnswerCount();
}
