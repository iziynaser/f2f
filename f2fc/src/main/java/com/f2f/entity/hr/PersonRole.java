package com.f2f.entity.hr;

import com.f2f.entity.common.Person;
import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "PERSON_ROLE")
public class PersonRole extends BaseEntity implements Serializable {

    private Person person;

    @Column(name = "ROLE_NAME")
    private String roleName;

    @Column(name = "FROM_DATE")
    private String fromDate;

    @Column(name = "TO_DATE")
    private String toDate;

    public PersonRole() {
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
