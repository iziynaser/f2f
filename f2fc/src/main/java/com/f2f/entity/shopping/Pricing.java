package com.f2f.entity.shopping;

import com.f2f.entity.common.Person;
import com.f2f.entity.product.Product;
import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "PRICING")
public class Pricing extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person personId ;

    @Column(name = "pricing_type_id")
    private PricingType pricingType;

    @Column(name = "from_date")
    private String fromDate ;

    @Column(name = "through_date")
    private String throughDate ;

    @Column(name = "product_count")
    private int productCount ;

    @Column(name = "price_amount")
    private long priceAmount ;

    @Column(name = "geo_location")
    private String geo_location;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public String getGeo_location() {
        return geo_location;
    }

    public void setGeo_location(String geo_location) {
        this.geo_location = geo_location;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public PricingType getPricingType() {
        return pricingType;
    }

    public void setPricingType(PricingType pricingType) {
        this.pricingType = pricingType;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getThroughDate() {
        return throughDate;
    }

    public void setThroughDate(String throughDate) {
        this.throughDate = throughDate;
    }

    public long getPriceAmount() {
        return priceAmount;
    }

    public void setPriceAmount(long priceAmount) {
        this.priceAmount = priceAmount;
    }
}
