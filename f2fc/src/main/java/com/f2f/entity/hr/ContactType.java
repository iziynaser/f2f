package com.f2f.entity.hr;

import com.f2f.persistence.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by mbzo on 1/23/15.
 */

@Entity
@Table(name = "CONTACT_TYPE")
public class ContactType extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    private Contact contact;

    public ContactType() {
    }

    public ContactType(String name, String description) {
        this.name = name;
        //this.version = version;
        this.description = description;
    }

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
}
