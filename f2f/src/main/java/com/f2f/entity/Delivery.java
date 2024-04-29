package com.f2f.entity;

import com.f2f.persistance.entity.BaseEntity;
import com.f2f.persistance.entity.UserAccountEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DELIVERY")
public class Delivery extends BaseEntity implements Serializable {

    @ManyToOne
    private UserAccountEntity userAccountEntity;

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

    public Ostan getOstan() {
        return ostan;
    }

    public void setOstan(Ostan ostan) {
        this.ostan = ostan;
    }

    public Shahr getShahr() {
        return shahr;
    }

    public void setShahr(Shahr shahr) {
        this.shahr = shahr;
    }

    public String getPostalAdress() {
        return postalAdress;
    }

    public void setPostalAdress(String postalAdress) {
        this.postalAdress = postalAdress;
    }

    public String getPelak() {
        return pelak;
    }

    public void setPelak(String pelak) {
        this.pelak = pelak;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getDeliverName() {
        return deliverName;
    }

    public void setDeliverName(String deliverName) {
        this.deliverName = deliverName;
    }

    public String getDeliverFamily() {
        return deliverFamily;
    }

    public void setDeliverFamily(String deliverFamily) {
        this.deliverFamily = deliverFamily;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getMobileNo1() {
        return mobileNo1;
    }

    public void setMobileNo1(String mobileNo1) {
        this.mobileNo1 = mobileNo1;
    }

    public String getMobileNo2() {
        return mobileNo2;
    }

    public void setMobileNo2(String mobileNo2) {
        this.mobileNo2 = mobileNo2;
    }

    public String getWhoisGetter() {
        return whoisGetter;
    }

    public void setWhoisGetter(String whoisGetter) {
        this.whoisGetter = whoisGetter;
    }

    public String getGeoCode() {
        return geoCode;
    }

    public void setGeoCode(String geoCode) {
        this.geoCode = geoCode;
    }

    public UserAccountEntity getUserAccountEntity() {
        return userAccountEntity;
    }

    public void setUserAccountEntity(UserAccountEntity userAccountEntity) {
        this.userAccountEntity = userAccountEntity;
    }
}
