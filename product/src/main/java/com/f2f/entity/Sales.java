package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "SALES")
public class Sales extends BaseEntity implements Serializable {

    private Product product;

    private Long invoiceId;

    @Column(name = "SALES_DATE")
    private Integer salesDate;

}
