package com.f2f.dto;

import lombok.Data;

@Data
public class CategoryDTO {
    private String name ;
    private String parentCategory ;
    private String description ;
    private String categoryCode ;
    private String categoryType ;

    public CategoryDTO(){
        super();
    }
}
