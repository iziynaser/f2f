package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "SUPPLIERPRODUCT")
public class SupplierProduct  extends BaseEntity implements Serializable {

    private LocalDate availableFromDate;

    private LocalDate availableThruDate;

}
