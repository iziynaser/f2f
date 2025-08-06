package com.f2f.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductFeatureTreeDTO {
    private String name;
    private String value;
    private List<ProductFeatureTreeDTO> children = new ArrayList<>();

    public ProductFeatureTreeDTO(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
