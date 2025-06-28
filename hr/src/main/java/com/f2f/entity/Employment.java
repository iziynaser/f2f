package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYMENT")
public class Employment extends BaseEntity implements Serializable {

    @Column(name = "EMPLOYMENT_TYPE")
    private String employmentType;

    @Column(name = "START_EMPLOYMENT_DATE")
    private String startEmploymentDate;

    @Column(name = "END_EMPLOYMENT_DATE")
    private String endEmploymentDate;
}
