package com.f2f.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BaseDomain implements Serializable {

    private String id;
    /**
     * creation time
     */
    private LocalDateTime dateCreated;
    /**
     * change the time
     */
    private LocalDateTime lastModified;
    private int recordStatus;
    private int sortPriority;
    /**
     * number of changes /+1 per modification
     */
    private int version;
    private String remarks;
    private String additionalData;
}
