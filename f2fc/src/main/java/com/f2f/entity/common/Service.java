package com.f2f.entity.common;


import com.f2f.dbc.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "SERVICE")
public class Service extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToMany(mappedBy = "services")
    private Collection<Group> groups;

    public Service() {
    }

    public Service( String name, String description, Collection<Group> groups) {
        this.name = name;
        this.description = description;
        this.groups = groups;
    }

    public Collection<Group> getGroups() {
        return groups;
    }

    public void setGroups(Collection<Group> groups) {
        this.groups = groups;
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

    public String toString(){
        StringBuffer sb = new StringBuffer();
//        sb.append("id :"+ id +" ,");
        sb.append("name :"+ name +" ,");
        sb.append("description :"+ description +" ,");
        return sb.toString();
    }

}
