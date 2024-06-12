package com.f2f.entity.product;

import com.f2f.persistence.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "PRODUCT_KEYWORD")
public class ProductKeyword extends BaseEntity implements Serializable {

    @ManyToOne
    private Product product;

    @Column(name = "KEY_NAME")
    private String keyName ;

    @Column(name = "KEY_WEIGHT")
    private String keyWeight;

    @Column(name = "KEY_STATUS")
    private String keyStatus;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyWeight() {
        return keyWeight;
    }

    public void setKeyWeight(String keyWeight) {
        this.keyWeight = keyWeight;
    }

    public String getKeyStatus() {
        return keyStatus;
    }

    public void setKeyStatus(String keyStatus) {
        this.keyStatus = keyStatus;
    }

    public ProductKeyword(){
        super();
    }

    public ProductKeyword(Product product,String keyName,String keyWeight,String keyStatus){
        super();
        this.product = product;
        this.keyStatus = keyStatus;
        this.keyWeight = keyWeight;
        this.keyName = keyName;
    }
}
