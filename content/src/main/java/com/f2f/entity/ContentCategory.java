package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "CONTENT_CATEGORY")
public class ContentCategory extends BaseEntity implements Serializable {

    @ManyToOne
    private Content content;

    //@ManyToOne
    private Long categoryId ;

}
