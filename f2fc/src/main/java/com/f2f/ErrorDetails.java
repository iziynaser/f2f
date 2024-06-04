package com.f2f;

import java.util.Date;

public class ErrorDetails {
    private Date dateTime;
    private String message ;
    private String details ;

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public ErrorDetails(Date dateTime, String message, String details) {
        this.dateTime = dateTime;
        this.message = message;
        this.details = details;
    }
}
