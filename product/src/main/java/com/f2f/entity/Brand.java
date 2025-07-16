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

    private Long brand_code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "VALUE")
    private String value;

    @ManyToOne
    private Category category;

}
