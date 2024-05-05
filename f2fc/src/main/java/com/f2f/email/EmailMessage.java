package com.f2f.email;

import com.f2f.persistance.entity.EmailAddressEntity;

import java.io.Serializable;
import java.util.Set;

public class EmailMessage implements Serializable {

    private Long id;

    private Long version;
    private String subject;
    Set<EmailMessageAttachment> attachments;
    Set<EmailAddressEntity> recipients;
    EmailAddressEntity from;
    EmailAddressEntity replyTo;
    Boolean succeeded;
    String sendDate;
    String sendAttemptCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Set<EmailMessageAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(Set<EmailMessageAttachment> attachments) {
        this.attachments = attachments;
    }

    public Set<EmailAddressEntity> getRecipients() {
        return recipients;
    }

    public void setRecipients(Set<EmailAddressEntity> recipients) {
        this.recipients = recipients;
    }

    public EmailAddressEntity getFrom() {
        return from;
    }

    public void setFrom(EmailAddressEntity from) {
        this.from = from;
    }

    public EmailAddressEntity getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(EmailAddressEntity replyTo) {
        this.replyTo = replyTo;
    }

    public Boolean getSucceeded() {
        return succeeded;
    }

    public void setSucceeded(Boolean succeeded) {
        this.succeeded = succeeded;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getSendAttemptCount() {
        return sendAttemptCount;
    }

    public void setSendAttemptCount(String sendAttemptCount) {
        this.sendAttemptCount = sendAttemptCount;
    }
}
