package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TAG")
public class Tag extends BaseEntity implements Serializable {

    @Column(name = "LANGUAGE")
    private String language ;

    @Column(name = "name")
    private String name ;

    @ManyToMany(mappedBy = "tags")
    private List<Content> contents = new ArrayList<>();
}
