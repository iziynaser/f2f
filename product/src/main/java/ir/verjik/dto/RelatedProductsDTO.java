package ir.verjik.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RelatedProductsDTO {
    private String name ;
    private String shortDesc ;
    private String imgUrl ;
    private String amazingDesc;
    private String price ;

    @Override
    public String toString() {
        return "RelatedProductsDTO{" +
                "name='" + name + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", amazingDesc='" + amazingDesc + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
