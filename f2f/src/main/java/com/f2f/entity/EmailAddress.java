package com.f2f.entity;

import com.f2f.email.EmailAddressType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.f2f.domain.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class EmailAddress extends BaseDomain {

    private Integer personId;
    private String address;
    private String fullName;
    private EmailAddressType addressType;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
