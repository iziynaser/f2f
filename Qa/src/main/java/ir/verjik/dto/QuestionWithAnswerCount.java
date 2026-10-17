package ir.verjik.dto;

public interface QuestionWithAnswerCount {
    Long getId();
    String getSubject();
    String getBody();
    Long getAnswerCount();
}
