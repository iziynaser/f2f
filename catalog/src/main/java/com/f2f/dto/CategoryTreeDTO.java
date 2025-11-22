package com.f2f.dto;

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
public class CategoryTreeDTO {
    private Long id;
    private String name;
    private String categoryCode;
    private List<CategoryTreeDTO> subCategories = new ArrayList<>();
}
