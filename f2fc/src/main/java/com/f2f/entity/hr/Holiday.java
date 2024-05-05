package com.f2f.entity.hr;

import com.f2f.persistance.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "HOLIDAY")
public class Holiday extends BaseEntity implements Serializable {

    public Holiday() {
    }

}
