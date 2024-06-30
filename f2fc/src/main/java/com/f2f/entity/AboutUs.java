package com.f2f.entity;

import com.f2f.persistence.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ABOUTUS")
public class AboutUs extends BaseEntity implements Serializable {

    @Column(name = "COMPANY_NAME")
    private String companyName ;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "EMAIL")
    private String email ;

    @Column(name = "FAX")
    private String fax;

    @Column(name = "TEL")
    private String tel;

    @Column(name = "DESCRIPTION")
    private String desc;

    @Column(name = "LINKEDIN_ADDRESS")
    private String linkedInAddress;

    @Column(name = "LINKEDIN_ENABLE")
    private boolean isLinkedInEnable=false;

    @Column(name = "APARAT_ADDRESS")
    private String aparatAddress;

    @Column(name = "APARAT_ENABLE")
    private boolean isAparatEnable=false;

    @Column(name = "INSTA_ADDRESS")
    private String instaAddress;

    @Column(name = "INSTA_ENABLE")
    private boolean isInstaEnable=false;

    @Column(name = "TWITTER_ADDRESS")
    private String twitterAddress;

    @Column(name = "TWITT_ENABLE")
    private boolean isTwittEnable=false;

    public boolean isLinkedInEnable() {
        return isLinkedInEnable;
    }

    public void setLinkedInEnable(boolean linkedInEnable) {
        isLinkedInEnable = linkedInEnable;
    }

    public boolean isAparatEnable() {
        return isAparatEnable;
    }

    public void setAparatEnable(boolean aparatEnable) {
        isAparatEnable = aparatEnable;
    }

    public boolean isInstaEnable() {
        return isInstaEnable;
    }

    public void setInstaEnable(boolean instaEnable) {
        isInstaEnable = instaEnable;
    }

    public boolean isTwittEnable() {
        return isTwittEnable;
    }

    public void setTwittEnable(boolean twittEnable) {
        isTwittEnable = twittEnable;
    }

    public String getLinkedInAddress() {
        return linkedInAddress;
    }

    public void setLinkedInAddress(String linkedInAddress) {
        this.linkedInAddress = linkedInAddress;
    }

    public String getAparatAddress() {
        return aparatAddress;
    }

    public void setAparatAddress(String aparatAddress) {
        this.aparatAddress = aparatAddress;
    }

    public String getInstaAddress() {
        return instaAddress;
    }

    public void setInstaAddress(String instaAddress) {
        this.instaAddress = instaAddress;
    }

    public String getTwitterAddress() {
        return twitterAddress;
    }

    public void setTwitterAddress(String twitterAddress) {
        this.twitterAddress = twitterAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
