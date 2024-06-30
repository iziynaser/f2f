package com.f2f.entity.common;


import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "GROUPS")
public class Group extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @ManyToMany
    @JoinTable(name = "GROUP_SERVICE",joinColumns = @JoinColumn(name = "GROUP_ID"),
               inverseJoinColumns = @JoinColumn(name = "SERVICE_ID"))
    private Collection<Service> services;

    @ManyToMany(mappedBy = "groups")
    private Collection<Person> persons;

    public Group() {
    }

    public Group(String name, String description, String status, String externalId, Collection<Service> services, Collection<Person> persons) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.externalId = externalId;
        this.services = services;
        this.persons = persons;
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

    public Collection<Service> getServices() {
        return services;
    }

    public void setServices(Collection<Service> services) {
        this.services = services;
    }

    public Collection<Person> getPersons() {
        return persons;
    }

    public void setPersons(Collection<Person> persons) {
        this.persons = persons;
    }
}
