package com.f2f.back.entity;

import com.f2f.persistence.entity.BaseEntity;

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
    public Boolean linkedInAddressEnabled;

    @Column(name = "APARAT_ADDRESS")
    public String aparatAddress;
    @Column(name = "APARAT_ADDRESS_ENABLED")
    public Boolean aparatAddressEnabled;

    @Column(name = "INSTA_ADDRESS")
    public String instaAddress;
    @Column(name = "INSTA_ADDRESS_ENABLED")
    public Boolean  instaAddressEnabled;
    @Column(name = "TWITTER_ADDRESS")
    public String twitterAddress;
    @Column(name = "TWITTER_ADDRESS_ENABLED")
    public Boolean twitterAddressEnabled;

    public String getLinkedInAddress() {
        return linkedInAddress;
    }

    public void setLinkedInAddress(String linkedInAddress) {
        this.linkedInAddress = linkedInAddress;
    }

    public Boolean getLinkedInAddressEnabled() {
        return linkedInAddressEnabled;
    }

    public void setLinkedInAddressEnabled(Boolean linkedInAddressEnabled) {
        this.linkedInAddressEnabled = linkedInAddressEnabled;
    }

    public String getAparatAddress() {
        return aparatAddress;
    }

    public void setAparatAddress(String aparatAddress) {
        this.aparatAddress = aparatAddress;
    }

    public Boolean getAparatAddressEnabled() {
        return aparatAddressEnabled;
    }

    public void setAparatAddressEnabled(Boolean aparatAddressEnabled) {
        this.aparatAddressEnabled = aparatAddressEnabled;
    }

    public String getInstaAddress() {
        return instaAddress;
    }

    public void setInstaAddress(String instaAddress) {
        this.instaAddress = instaAddress;
    }

    public Boolean getInstaAddressEnabled() {
        return instaAddressEnabled;
    }

    public void setInstaAddressEnabled(Boolean instaAddressEnabled) {
        this.instaAddressEnabled = instaAddressEnabled;
    }

    public String getTwitterAddress() {
        return twitterAddress;
    }

    public void setTwitterAddress(String twitterAddress) {
        this.twitterAddress = twitterAddress;
    }

    public Boolean getTwitterAddressEnabled() {
        return twitterAddressEnabled;
    }

    public void setTwitterAddressEnabled(Boolean twitterAddressEnabled) {
        this.twitterAddressEnabled = twitterAddressEnabled;
    }
}
