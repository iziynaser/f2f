package com.f2f.entity.acc;

import com.f2f.persistence.entity.BaseEntity;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "ACC_CURRENCY")
public class Currency extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name;

    @Column(name = "SYMBOL")
    private String symbol;

    @Column(name = "COUNTRY_NAME")
    private String countryName;

    @Column(name = "DESCRIPTION")
    private String description ;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Currency() {
    }

    public Currency(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }
}
