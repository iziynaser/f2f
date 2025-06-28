package com.f2f.dto;

import com.f2f.dto.ProductImageDTO;
import com.f2f.dto.ProductPriceDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDTO implements java.io.Serializable {
     private String name;
     private String id;
     private String comment;
     private String isVirtual;
     private String releaseDate;
     private String productCode;
     private String introDate;
     private String internalName;
     private String disContinuedDate;
     private String description;

     private ProductPriceDTO price;

     private Long minPrice;
     private Long maxPrice;
     private Double avgPrice;
     //private Long price ;

     private String type;

     private List<String> brands;
     private List<String> colors;

     @Override
     public String toString() {
          return "ProductDTO{" +
                  "name='" + name + '\'' +
                  ", id='" + id + '\'' +
                  ", comment='" + comment + '\'' +
                  ", isVirtual='" + isVirtual + '\'' +
                  ", releaseDate='" + releaseDate + '\'' +
                  ", productCode='" + productCode + '\'' +
                  ", introDate='" + introDate + '\'' +
                  ", internalName='" + internalName + '\'' +
                  ", disContinuedDate='" + disContinuedDate + '\'' +
                  '}';
     }
}
