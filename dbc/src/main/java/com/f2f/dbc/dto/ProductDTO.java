package com.f2f.dto;

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
     private String cardImageUrl;
     private ProductPriceDTO price;

     private Integer quantity;
     private Boolean available;

     private String type;

     private Integer totalLikes;
     private Integer totalDislikes;

     private List<String> brands;
     private List<ProductColorDTO> colors;

     private Long basePrice;
     private Long finalPrice;
     private Long discountAmount;
     private String appliedRuleName; // Optional

     private List<String> nonFinancialBenefits;

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
