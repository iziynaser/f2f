package com.f2f.entity;


import com.f2f.dbc.entity.BaseEntity;
import com.f2f.enums.FloatingDetailType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionIdJdbcTypeCode;

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
