package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "BRAND")
public class Brand extends BaseEntity {

    @Column(name = "CODE",unique = true,nullable = false)
    private String code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "VALUE")
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

}
