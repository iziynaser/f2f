package com.f2f.controller.product;

import java.util.List;

public class ProductFeatureTreeDTO {
        private String name;
        private String value ;
        private List<ProductFeatureTreeDTO> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<ProductFeatureTreeDTO> getChildren() {
        return children;
    }

    public void setChildren(List<ProductFeatureTreeDTO> children) {
        this.children = children;
    }

    public ProductFeatureTreeDTO(){

    }

    public ProductFeatureTreeDTO(String name,String value) {
        this.name = name;
        this.value = value;
    }
}
