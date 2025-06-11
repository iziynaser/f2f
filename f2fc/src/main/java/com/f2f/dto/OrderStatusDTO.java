package com.f2f.dto;

// OrderStatusDTO.java
import java.time.LocalDateTime;

public class OrderStatusDTO {
    private String status;
    private LocalDateTime statusDate;
    private String comment;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(LocalDateTime statusDate) {
        this.statusDate = statusDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
