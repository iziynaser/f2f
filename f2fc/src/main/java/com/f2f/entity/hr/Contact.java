package com.f2f.entity.hr;

import com.f2f.entity.common.Person;
import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CONTACT")
public class Contact extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name ;

    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL)
    private List<ContactType> contactTypes = new ArrayList<ContactType>();

    @Column(name = "DESCRIPTION")
    private String description ;

    @ManyToOne
    private Person person;

    public Contact(){
    }

    @Column(name = "FROM_DATE")
    private String fromDate;

    @Column(name = "TO_DATE")
    private String toDate ;

    @Column(name = "EXPIRED")
    private boolean expired;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ContactType> getContactTypes() {
        return contactTypes;
    }

    public void setContactTypes(List<ContactType> contactTypes) {
        this.contactTypes = contactTypes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}
