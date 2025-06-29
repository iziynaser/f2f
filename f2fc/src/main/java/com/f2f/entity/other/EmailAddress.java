package com.f2f.entity.other;

import com.f2f.dbc.domain.BaseDomain;
import com.f2f.email.EmailAddressType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
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
