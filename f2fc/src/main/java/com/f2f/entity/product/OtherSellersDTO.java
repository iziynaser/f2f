package com.f2f.entity.product;

public class OtherSellersDTO {
    private String nameOfSeller ;
    private long id ;
    private String conditions ;

    private long price;

    private String imgUrl ;

    private String promotions ;

    public String getNameOfSeller() {
        return nameOfSeller;
    }

    public void setNameOfSeller(String nameOfSeller) {
        this.nameOfSeller = nameOfSeller;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getPromotions() {
        return promotions;
    }

    public void setPromotions(String promotions) {
        this.promotions = promotions;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "OtherSellersDTO{" +
                "nameOfSeller='" + nameOfSeller + '\'' +
                ", id=" + id +
                ", conditions='" + conditions + '\'' +
                ", price='" + price + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", promotions='" + promotions + '\'' +
                '}';
    }
}
