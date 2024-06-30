package com.f2f.entity;

import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "SHAHR")
public class Shahr extends BaseEntity implements Serializable {

    @Column(name = "SHAHR_NAME")
    private String name;

    @ManyToOne
    private Ostan ostan;

    public Shahr(){
        super();
    }

    public Shahr(Long id){
        this.setId(id);
    }

    public Shahr(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ostan getOstan() {
        return ostan;
    }

    public void setOstan(Ostan ostan) {
        this.ostan = ostan;
    }
}
