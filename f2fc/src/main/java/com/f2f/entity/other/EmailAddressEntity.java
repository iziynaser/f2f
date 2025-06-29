package com.f2f.entity.other;

import com.f2f.email.EmailAddressType;
import com.f2f.dbc.entity.BaseEntity;
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
