package com.f2f.entity.product;

import com.f2f.dto.ProductImageDTO;
import com.f2f.dto.ProductPriceDTO;

import java.util.List;

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


     public String getType() {
          return type;
     }

     public void setType(String type) {
          this.type = type;
     }

     public Long getMinPrice() {
          return minPrice;
     }

     public void setMinPrice(Long minPrice) {
          this.minPrice = minPrice;
     }

     public Long getMaxPrice() {
          return maxPrice;
     }

     public void setMaxPrice(Long maxPrice) {
          this.maxPrice = maxPrice;
     }

     public Double getAvgPrice() {
          return avgPrice;
     }

     public void setAvgPrice(Double avgPrice) {
          this.avgPrice = avgPrice;
     }

     public List<String> getBrands() {
          return brands;
     }

     public void setBrands(List<String> brands) {
          this.brands = brands;
     }

     public List<String> getColors() {
          return colors;
     }

     public void setColors(List<String> colors) {
          this.colors = colors;
     }

     public ProductPriceDTO getPrice() {
          return price;
     }

     public void setPrice(ProductPriceDTO price) {
          this.price = price;
     }

     private List<ProductImageDTO> images;

     public List<ProductImageDTO> getImages() {
          return images;
     }

     public void setImages(List<ProductImageDTO> images) {
          this.images = images;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getComment() {
          return comment;
     }

     public void setComment(String comment) {
          this.comment = comment;
     }

     public String getIsVirtual() {
          return isVirtual;
     }

     public void setIsVirtual(String isVirtual) {
          this.isVirtual = isVirtual;
     }

     public String getReleaseDate() {
          return releaseDate;
     }

     public void setReleaseDate(String releaseDate) {
          this.releaseDate = releaseDate;
     }

     public String getProductCode() {
          return productCode;
     }

     public void setProductCode(String productCode) {
          this.productCode = productCode;
     }

     public String getIntroDate() {
          return introDate;
     }

     public void setIntroDate(String introDate) {
          this.introDate = introDate;
     }

     public String getInternalName() {
          return internalName;
     }

     public void setInternalName(String internalName) {
          this.internalName = internalName;
     }

     public String getDisContinuedDate() {
          return disContinuedDate;
     }

     public void setDisContinuedDate(String disContinuedDate) {
          this.disContinuedDate = disContinuedDate;
     }

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
