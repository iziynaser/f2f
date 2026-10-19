package ir.verjik.entity.other;

import ir.verjik.dbc.domain.BaseDomain;
import ir.verjik.email.EmailAddressType;
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
