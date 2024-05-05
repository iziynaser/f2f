package com.f2f.entity.common;

import com.f2f.persistance.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COMPANY")
public class CompanyB extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name;

    public CompanyB() {
    }

    public CompanyB(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
