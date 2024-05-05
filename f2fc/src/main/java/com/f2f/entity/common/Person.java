package com.f2f.entity.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.f2f.entity.hr.*;
//import com.revengemission.sso.oauth2.server.persistence.entity.BaseEntity;
import com.f2f.persistance.entity.BaseEntity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "PERSON")
public class Person extends BaseEntity implements Serializable {

    @Column(name = "TITLE")
    private Boolean title;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "DATE_OF_BIRTH")
    private String dateOfBirth;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "DESCRIPTION")
    private String description;

    //@OneToMany(targetEntity = Connection.class,mappedBy = "person")
    //@Column(name = "CONNECTION_ID")
    @OneToMany
    private Collection<Connection> additionalConnection;

    @OneToOne
    //@JoinColumn(name = "LOGIN_ID")
    private Login login;

    //@ManyToMany
    //@JoinTable(name = "PERSON_GROUPS",
    //           joinColumns = @JoinColumn(name = "PERSON_ID",referencedColumnName = "PERSON_ID"),
    //           inverseJoinColumns = @JoinColumn(name = "GROUP_ID",referencedColumnName = "GROUP_ID"))
    @ManyToMany
    private Collection<Group> groups;

    //@JsonIgnore
    //@OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    @OneToMany
    private List<Skill> skills = new ArrayList<Skill>();

    //@JsonIgnore
    //@OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    @OneToMany
    private List<Training> trainings = new ArrayList<Training>();

    //@JsonIgnore
    //@OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    @OneToMany
    private  List<WorkSheet> workSheets = new ArrayList<WorkSheet>();

    //@JsonIgnore
    //OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    @OneToMany
    private List<Position> positions = new ArrayList<Position>();

    //@JsonIgnore
    //@OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    @OneToMany
    private List<Contact> contacts = new ArrayList<Contact>();

    public Person() {
    }

    public Boolean getTitle() {
        return title;
    }

    public void setTitle(Boolean title) {
        this.title = title;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Collection<Connection> getAdditionalConnection() {
        return additionalConnection;
    }

    public void setAdditionalConnection(Collection<Connection> additionalConnection) {
        this.additionalConnection = additionalConnection;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Collection<Group> getGroups() {
        return groups;
    }

    public void setGroups(Collection<Group> groups) {
        this.groups = groups;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }

    public List<WorkSheet> getWorkSheets() {
        return workSheets;
    }

    public void setWorkSheets(List<WorkSheet> workSheets) {
        this.workSheets = workSheets;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

}
