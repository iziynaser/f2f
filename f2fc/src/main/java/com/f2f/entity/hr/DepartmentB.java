package com.f2f.entity.hr;

import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "DEPARTMENT")
public class DepartmentB extends BaseEntity implements Serializable {

    @Column(name = "DESCRIPTION")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DepartmentB() {
    }

    public DepartmentB(String description) {
        this.description = description;
    }
}
