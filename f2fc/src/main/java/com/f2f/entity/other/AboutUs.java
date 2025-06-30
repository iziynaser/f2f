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
}
