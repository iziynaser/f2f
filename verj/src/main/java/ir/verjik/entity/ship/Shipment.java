package ir.verjik.entity.ship;

import ir.verjik.dbc.entity.BaseEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "SHIPMENT")
public class Shipment extends BaseEntity implements Serializable {

    @Column(name = "READY_DATE")
    private Integer readyDate;

    @Column(name = "SHIP_DATE")
    private Integer shipDate;

    @Column(name = "ARRIVAL_DATE")
    private Integer arrivalDate;

}
