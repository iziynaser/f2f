package com.f2f.entity;

import com.f2f.persistence.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "OSTAN")
public class Ostan extends BaseEntity implements Serializable {

    @Column(name = "OSTAN_NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ostan(){
        super();
    }

    public Ostan(String name){
        this.name = name;
    }

    public Ostan(Long id){
        this.setId(id);
    }

}
