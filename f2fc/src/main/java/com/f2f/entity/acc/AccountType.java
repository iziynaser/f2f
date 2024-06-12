package com.f2f.entity.acc;

import com.f2f.persistence.entity.BaseEntity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ACCOUT_TYPE")

public class AccountType extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AccountType() {
    }

    public AccountType(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
