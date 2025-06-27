package com.f2f.entity.common;


import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "SERVICE")
public class Service extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    //@ManyToMany(mappedBy = "services")
    //private Collection<Group> groups;

    public Service() {
    }
}
