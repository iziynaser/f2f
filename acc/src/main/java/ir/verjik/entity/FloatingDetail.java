package ir.verjik.entity;


import ir.verjik.dbc.entity.BaseEntity;
import ir.verjik.enums.FloatingDetailType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="FLOATING_DETAIL")
public class FloatingDetail  extends BaseEntity implements Serializable {

    @Enumerated(EnumType.STRING)
    @Column(name="TYPE")
    private FloatingDetailType type;

    @Column(name = "REF_ID",nullable = false)
    Long referenceId;  // id از جدول مربوطه مثلا Person.id
}
