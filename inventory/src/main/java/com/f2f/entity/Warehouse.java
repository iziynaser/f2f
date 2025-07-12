package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "WAREHOUSE")
public class Warehouse extends BaseEntity {
    private String warehouseName;
    private String warehouseCode;
    private String warehouseType;
    private String warehouseAddress;
    private String warehouseCity;
    private String warehouseDistrict;
    private String warehouseState;
    private String warehouseZip;
}
