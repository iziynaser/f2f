package com.f2f.entity.hr;

import com.f2f.entity.common.Person;
import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CONNECTION")
public class Connection extends BaseEntity implements Serializable {

    @OneToOne
    private ConnectionType connectionType;

    @ManyToOne
    private Person person;

    @Column(name = "CONNECTION_VALUE")
    private String connectionValue;

    @Column(name = "AVAILABLE")
    private Boolean available;

    public Connection() {
    }

    public Connection(ConnectionType connectionType, Person person, String connectionValue, Boolean available) {
        this.connectionType = connectionType;
        this.person = person;
        this.connectionValue = connectionValue;
        this.available = available;
    }

    public ConnectionType getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(ConnectionType connectionType) {
        this.connectionType = connectionType;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getConnectionValue() {
        return connectionValue;
    }

    public void setConnectionValue(String connectionValue) {
        this.connectionValue = connectionValue;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
