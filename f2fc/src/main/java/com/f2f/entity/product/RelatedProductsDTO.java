package com.f2f.entity.product;

public class RelatedProductsDTO {
    private String name ;
    private String shortDesc ;
    private String imgUrl ;
    private String amazingDesc;
    private String price ;

    private long id ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAmazingDesc() {
        return amazingDesc;
    }

    public void setAmazingDesc(String amazingDesc) {
        this.amazingDesc = amazingDesc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RelatedProductsDTO{" +
                "name='" + name + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", amazingDesc='" + amazingDesc + '\'' +
                ", price='" + price + '\'' +
                ", id=" + id +
                '}';
    }
}
