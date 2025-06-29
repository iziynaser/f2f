package com.f2f.dbc.domain;

//import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class LoginHistory extends BaseDomain {

	private static final long serialVersionUID = -3503838536778480869L;
	private String clientId;
    private String username;
    private String ip;
    private String device;

}
