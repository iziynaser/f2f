package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "DELIVERY")
public class Delivery extends BaseEntity implements Serializable {

    private Long userAccountId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ostan ostan;

    @ManyToOne(fetch = FetchType.LAZY)
    private Shahr shahr;

    @Column(name = "POSTAL_ADDRESS")
    private String postalAddress ;

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

    @Column(name = "latitude")
    private String latitude ;

    @Column(name = "longitude")
    private String longitude  ;

    @Enumerated(EnumType.STRING)
    @Column(name = "DELIVERY_STATUS")
    private DeliveryStatus deliveryStatus;

    @Column(name = "DELIVERY_TIME")
    private LocalDateTime deliveryTime;

    @Column(name = "DELIVERY_DATE")
    private LocalDate deliveryDate ;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "is_default")
    private boolean isDefault;

}
