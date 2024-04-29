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

}
