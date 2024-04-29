package com.revengemission.sso.oauth2.server.f2f.domain.budget;

import com.f2f.persistance.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BUDGET_TYPE")
public class BudgetType extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "BUDGET_TYPE")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTON")
    private String description ;

    public BudgetType() {
    }

    public BudgetType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("id "+ id +",");
        sb.append("name "+ name +",");
        sb.append("description "+ description +",");

        return sb.toString();
    }
}
