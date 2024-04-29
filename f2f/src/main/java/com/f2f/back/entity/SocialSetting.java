package com.f2f.back.entity;

//import com.revengemission.sso.oauth2.server.persistence.entity.BaseEntity;
import com.f2f.persistance.entity.BaseEntity;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "SOCIAL_SETTING")
public class SocialSetting extends BaseEntity implements Serializable {

    public SocialSetting() {
    }

    @Column(name = "LINKEDIN_ADDRESS")
    public String linkedInAddress;
    @Column(name = "LINKEDIN_ADDRESS_ENABLE")
    public Bool linkedInAddressEnabled;

    @Column(name = "APARAT_ADDRESS")
    public String aparatAddress;
    @Column(name = "APARAT_ADDRESS_ENABLED")
    public Bool aparatAddressEnabled;

    @Column(name = "INSTA_ADDRESS")
    public String instaAddress;
    @Column(name = "INSTA_ADDRESS_ENABLED")
    public Bool  instaAddressEnabled;
    @Column(name = "TWITTER_ADDRESS")
    public String twitterAddress;
    @Column(name = "TWITTER_ADDRESS_ENABLED")
    public Bool twitterAddressEnabled;

    public String getLinkedInAddress() {
        return linkedInAddress;
    }

    public void setLinkedInAddress(String linkedInAddress) {
        this.linkedInAddress = linkedInAddress;
    }

    public Bool getLinkedInAddressEnabled() {
        return linkedInAddressEnabled;
    }

    public void setLinkedInAddressEnabled(Bool linkedInAddressEnabled) {
        this.linkedInAddressEnabled = linkedInAddressEnabled;
    }

    public String getAparatAddress() {
        return aparatAddress;
    }

    public void setAparatAddress(String aparatAddress) {
        this.aparatAddress = aparatAddress;
    }

    public Bool getAparatAddressEnabled() {
        return aparatAddressEnabled;
    }

    public void setAparatAddressEnabled(Bool aparatAddressEnabled) {
        this.aparatAddressEnabled = aparatAddressEnabled;
    }

    public String getInstaAddress() {
        return instaAddress;
    }

    public void setInstaAddress(String instaAddress) {
        this.instaAddress = instaAddress;
    }

    public Bool getInstaAddressEnabled() {
        return instaAddressEnabled;
    }

    public void setInstaAddressEnabled(Bool instaAddressEnabled) {
        this.instaAddressEnabled = instaAddressEnabled;
    }

    public String getTwitterAddress() {
        return twitterAddress;
    }

    public void setTwitterAddress(String twitterAddress) {
        this.twitterAddress = twitterAddress;
    }

    public Bool getTwitterAddressEnabled() {
        return twitterAddressEnabled;
    }

    public void setTwitterAddressEnabled(Bool twitterAddressEnabled) {
        this.twitterAddressEnabled = twitterAddressEnabled;
    }
}
