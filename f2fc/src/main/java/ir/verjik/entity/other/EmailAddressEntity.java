package ir.verjik.entity.other;

import ir.verjik.email.EmailAddressType;
import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Entity
public class EmailAddressEntity extends BaseEntity implements Serializable  {

    private Integer personId;

    private String emailAddress;
    private String fullName;
    private EmailAddressType addressType;

 }
