package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
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

//    @ManyToMany
//    @JoinTable(name = "GROUP_SERVICE",
//            joinColumns = @JoinColumn(name = "group_id"),
//            inverseJoinColumns = @JoinColumn(name = "service_id"))
//    private Collection<Service> services;


    @ManyToMany(mappedBy = "groups")
    private Collection<PersonEntity> persons;

    public Group() {
    }

//    public Group(String name, String description, String status, String externalId, Collection<Service> services, Collection<Person> persons) {
//        this.name = name;
//        this.description = description;
//        this.status = status;
//        this.externalId = externalId;
//        this.services = services;
//        this.persons = persons;
//    }

}
