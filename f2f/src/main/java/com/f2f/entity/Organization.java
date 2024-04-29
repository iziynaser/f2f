package com.f2f.entity;


public class Organization {
    private String name;
    private String yype; // LEGAL,INFORMAL(TEAM,FAMILY,OTHER INFORMAL)
    private String brandings;
    private String govermentalAgency;
    private String taxId;
    private Organization parentOrg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYype() {
        return yype;
    }

    public void setYype(String yype) {
        this.yype = yype;
    }

    public String getBrandings() {
        return brandings;
    }

    public void setBrandings(String brandings) {
        this.brandings = brandings;
    }

    public String getGovermentalAgency() {
        return govermentalAgency;
    }

    public void setGovermentalAgency(String govermentalAgency) {
        this.govermentalAgency = govermentalAgency;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }
}
