package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "OSTAN")
public class Ostan extends BaseEntity implements Serializable {

    @Column(name = "OSTAN_NAME")
    private String name;

}
