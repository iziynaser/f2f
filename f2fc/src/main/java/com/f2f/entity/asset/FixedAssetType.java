package com.f2f.entity.asset;

import com.f2f.persistence.entity.BaseEntity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FIXED_ASSET_TYPE")
public class FixedAssetType extends BaseEntity implements Serializable {

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
    public FixedAssetType(){

    }
    public FixedAssetType(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
