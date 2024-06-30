package com.f2f.entity.common;

import com.f2f.persistence.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "SUBJECT")
public class Subject extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name ;

    @Column(name = "DESCRIPTION")
    private String description;

    public Subject() {
    }

    public Subject(String name, String description) {
        this.name = name;
        this.description = description;
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
        description = description;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        //sb.append("id :"+ id +" ,");
        sb.append("name :"+ name +" ,");
        sb.append("description :"+ description +" ,");
        return sb.toString();
    }
}
