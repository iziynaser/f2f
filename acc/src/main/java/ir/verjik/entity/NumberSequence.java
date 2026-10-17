package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
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
