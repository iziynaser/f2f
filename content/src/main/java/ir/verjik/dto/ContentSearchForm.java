package ir.verjik.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ContentSearchForm implements Serializable {

    private String name;
    private String title ;
    private String purpose;
    private String fromDate;
    private String toDate;
    private String isPublic;
    private String status ;
    private String description ;
    private Short seq ;
    private String contentType;
}
