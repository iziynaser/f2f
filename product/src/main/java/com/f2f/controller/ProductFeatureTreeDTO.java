package com.f2f.controller;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductFeatureTreeDTO {
        private String name;
        private String value ;
        private List<ProductFeatureTreeDTO> children;

    public ProductFeatureTreeDTO(){

    }

    public ProductFeatureTreeDTO(String name,String value) {
        this.name = name;
        this.value = value;
    }
}
