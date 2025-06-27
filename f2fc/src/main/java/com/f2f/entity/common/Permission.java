package com.f2f.entity.common;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "PERMISSION")
public class Permission extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToOne
    @JoinColumn(name = "SERVICE_ID")
    private Service service;

//    @OneToOne
//    @JoinColumn(name = "GROUP_ID")
//    private Group group;

    public Permission() {
    }
}
