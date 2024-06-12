package com.f2f.entity.acc;

import com.f2f.persistence.entity.BaseEntity;
import javax.persistence.*;

@Entity
@Table(name = "TRANS_ACTION_TYPES")
public class TransActionTypes extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

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

    public TransActionTypes() {
    }

    public TransActionTypes(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
