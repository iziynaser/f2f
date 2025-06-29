package com.f2f.dbc.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class NotesEntity extends BaseEntity{

    //private static final long serialVersionUID = ;

    private String noteTitle;

    private String noteDescription;

}
