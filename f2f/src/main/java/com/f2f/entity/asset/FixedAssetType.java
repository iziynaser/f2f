package com.revengemission.sso.oauth2.server.f2f.domain.asset;

import com.f2f.persistance.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "FIXED_ASSET_TYPE")
public class FixedAssetType extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTON")
    private String description ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FixedAssetType(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
