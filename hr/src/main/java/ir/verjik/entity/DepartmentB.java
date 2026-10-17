package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "DEPARTMENT")
public class DepartmentB extends BaseEntity implements Serializable {

    @Column(name = "DESCRIPTION")
    private String description;
}
