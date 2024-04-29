package com.f2f.entity.product;

import java.io.Serializable;

public class SupplierProduct implements Serializable {

    private String availableFromDate;

    private String availableThruDate;

    public String getAvailableFromDate() {
        return availableFromDate;
    }

    public void setAvailableFromDate(String availableFromDate) {
        this.availableFromDate = availableFromDate;
    }

    public String gPricingTypeetAvailableThruDate() {
        return availableThruDate;
    }

    public void setAvailableThruDate(String availableThruDate) {
        this.availableThruDate = availableThruDate;
    }
}
