package com.f2f.entity.hr;

import com.f2f.dbc.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "HOLIDAY")
public class Holiday extends BaseEntity implements Serializable {

    public Holiday() {
    }

}
