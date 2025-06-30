package com.f2f.entity.other;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
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

}
