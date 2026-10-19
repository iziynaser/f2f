package ir.verjik.entity.common;

import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "COMPANY")
public class CompanyB extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name;

    public CompanyB() {
    }

    public CompanyB(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
