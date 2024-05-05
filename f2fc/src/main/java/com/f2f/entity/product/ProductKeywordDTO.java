package com.f2f.entity.product;

public class ProductKeywordDTO {

    private Long product;

    private String keyName ;

    private String keyWeight;

    private String keyStatus;

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
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
}
