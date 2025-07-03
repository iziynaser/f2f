package com.f2f.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SupplierProduct implements Serializable {

    private String availableFromDate;

    private String availableThruDate;

    public String getAvailableFromDate() {
        return availableFromDate;
    }

}
