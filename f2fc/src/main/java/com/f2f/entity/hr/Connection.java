package com.f2f.entity.hr;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.entity.PersonEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "CONNECTION")
public class Connection extends BaseEntity implements Serializable {

    @OneToOne
    private ConnectionType connectionType;

    @ManyToOne
    private PersonEntity person;

    @Column(name = "CONNECTION_VALUE")
    private String connectionValue;

    @Column(name = "AVAILABLE")
    private Boolean available;

    public Connection() {
    }

//    public Connection(ConnectionType connectionType, Person person, String connectionValue, Boolean available) {
//        this.connectionType = connectionType;
//        this.person = person;
//        this.connectionValue = connectionValue;
//        this.available = available;
//    }

 }
