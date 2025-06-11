package com.f2f.entity.hr;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.entity.PersonEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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
    private PersonEntity person;

    public Contact(){
    }

    @Column(name = "FROM_DATE")
    private String fromDate;

    @Column(name = "TO_DATE")
    private String toDate ;

    @Column(name = "EXPIRED")
    private boolean expired;
}
