package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OtherSellersDTO {
    private String nameOfSeller ;
    private long id ;
    private String conditions ;
    private String price ;
    private String imgUrl;
    private String promotions ;

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
