package com.f2f.entity;

import com.f2f.email.EmailAddressType;
import com.f2f.persistence.entity.BaseEntity;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class EmailAddressEntity extends BaseEntity implements Serializable  {

    private Integer personId;

    private String emailAddress;
    private String fullName;
    private EmailAddressType addressType;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public EmailAddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(EmailAddressType addressType) {
        this.addressType = addressType;
    }
}
