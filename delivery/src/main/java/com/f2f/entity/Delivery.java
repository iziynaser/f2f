package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "DELIVERY")
public class Delivery extends BaseEntity implements Serializable {

//    @ManyToOne
    private Long userAccountId;

    @OneToOne
    //@Column(name = "OSTAN_ID")
    private Ostan ostan;

    @OneToOne
    //@Column(name = "SHAHR_ID")
    private Shahr shahr;

    //private Bakhsh bakhsh;

    @Column(name = "POSTAL_ADDRESS")
    private String postalAdress;

    @Column(name = "PELAK")
    private String pelak;

    @Column(name = "UNIT")
    private String unit;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "DELIVER_NAME")
    private String deliverName;

    @Column(name = "DELIVER_FAMIL")
    private String deliverFamily;

    @Column(name = "NATIONAL_CODE")
    private String nationalCode;

    @Column(name = "MOBILE_NO")
    private String mobileNo1;

    @Column(name = "MOBILE_NO2")
    private String mobileNo2;

    @Column(name = "WHO_IS_GETTER")
    private String whoisGetter;

    @Column(name = "GEO_CODE")
    private String geoCode;

    @Column(name = "DELIVERY_STATUS")
    private int deliveryStatus;

    @Column(name = "DELIVERY_TIME")
    private int deliveryTime;

    @Column(name = "DELIVERY_DATE")
    private int deliveryDate ;

    @Column(name = "is_active")
    private boolean isActive;
}
