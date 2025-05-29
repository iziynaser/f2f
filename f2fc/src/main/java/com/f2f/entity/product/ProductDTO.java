package com.f2f.entity.product;

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
