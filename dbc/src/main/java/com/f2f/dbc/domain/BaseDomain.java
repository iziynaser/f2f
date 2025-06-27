
package com.f2f.dbc.domain;

//import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

//@JsonInclude(JsonInclude.Include.NON_NULL)
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public int getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(int recordStatus) {
        this.recordStatus = recordStatus;
    }

    public int getSortPriority() {
        return sortPriority;
    }

    public void setSortPriority(int sortPriority) {
        this.sortPriority = sortPriority;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
    }
}
