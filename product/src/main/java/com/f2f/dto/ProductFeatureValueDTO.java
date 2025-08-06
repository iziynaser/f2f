package com.f2f.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductFeatureValueDTO {
    private Long id;
    private String name;
    private String value;
    private Integer order;
}
