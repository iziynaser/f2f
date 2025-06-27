package com.f2f.entity.ship;

import com.f2f.dbc.entity.BaseEntity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SHIPMENT")
public class Shipment extends BaseEntity implements Serializable {

    @Column(name = "READY_DATE")
    private Integer readyDate;

    @Column(name = "SHIP_DATE")
    private Integer shipDate;

    @Column(name = "ARRIVAL_DATE")
    private Integer arrivalDate;

    public Shipment() {
    }

    public Shipment(Integer readyDate, Integer shipDate, Integer arrivalDate) {
        this.readyDate = readyDate;
        this.shipDate = shipDate;
        this.arrivalDate = arrivalDate;
    }

}
