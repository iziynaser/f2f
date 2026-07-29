package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "number_sequence")
public class NumberSequence extends BaseEntity {

    @Column(nullable = false,updatable = false)
    private String sequenceKey ;

    @Column(nullable = false)
    private Long lastNumber;
}
