package com.f2f.email;

import com.f2f.domain.BaseDomain;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class EmailAddressType  extends BaseDomain {
    private String id;
    private String name ;
    private String description;
}
