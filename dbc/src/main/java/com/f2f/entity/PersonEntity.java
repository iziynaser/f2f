package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.dbc.entity.Gender;
//import com.f2f.entity.order.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PERSON")
public class PersonEntity extends BaseEntity implements Serializable {

    @Column(unique = true,name = "PERSON_CODE",nullable = false)
    private Long personCode;

    @Column(name = "TITLE")
    private Boolean title;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "DATE_OF_BIRTH")
    private LocalDateTime dateOfBirth;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "DESCRIPTION",length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Long loginId;

    private String email;
    private String mobile;
    private String nickName;
    private String avatarUrl;

    @ManyToMany
    @JoinTable(name = "PERSON_GROUPS",
            joinColumns = @JoinColumn(name = "PERSON_ID",referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "GROUP_ID",referencedColumnName = "ID"))
    private Collection<Group> groups;

//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Long> ordersId = new HashSet<>();

    /*
    //@OneToMany(targetEntity = Connection.class,mappedBy = "person")
    //@Column(name = "CONNECTION_ID")
//    @OneToMany
//    private Collection<Connection> additionalConnection;

    //@JsonIgnore
    //@OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
//    @OneToMany
//    private List<Skill> skills = new ArrayList<Skill>();

    //@JsonIgnore
    //@OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
//    @OneToMany
//    private List<Training> trainings = new ArrayList<Training>();

    //@JsonIgnore
    //@OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
//    @OneToMany
//    private  List<WorkSheet> workSheets = new ArrayList<WorkSheet>();

    //@JsonIgnore
    //OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
//    @OneToMany
//    private List<Position> positions = new ArrayList<Position>();

    //@JsonIgnore
    //@OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
//    @OneToMany
//    private List<Contact> contacts = new ArrayList<Contact>();

 */

}
