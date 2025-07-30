package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.enums.WarehouseType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "WAREHOUSE")
public class Warehouse extends BaseEntity {

    @Column(name = "wname")
    private String warehouseName;

    @Column(name = "wcode")
    private String warehouseCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "wtype")
    private WarehouseType warehouseType;

    @Column(name = "waddress")
    private String warehouseAddress;

    @Column(name = "wcity")
    private String warehouseCity;

    @Column(name = "wdistrict")
    private String warehouseDistrict;

    @Column(name = "wstate")
    private String warehouseState;

    @Column(name = "wzip")
    private String warehouseZip;
}
