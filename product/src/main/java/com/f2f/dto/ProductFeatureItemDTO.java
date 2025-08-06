package com.f2f.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductFeatureItemDTO {
    private Long id;
    private String name;
    private String value;
    private Integer order;
    private List<ProductFeatureValueDTO> values = new ArrayList<>();
}
