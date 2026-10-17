package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="PRODUCT_IMAGE")
public class ProductImage extends BaseEntity {

    @Column(name="name")
    private String name ;

    @Column(name = "type")
    private String type;//small,medium,large,detail,original,additional,detail,card

    @Column(name = "picByte",length = 2000)
    private byte [] picByte ;

    @Column(name = "url")
    private String url ;

    @Column(name = "decription")
    private String decription ;

    @Column(name = "is_user_image")
    private Boolean isUserImage;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductImage(){
        super();
    }

    public ProductImage(String name, String type, byte[] picByte){
        this.name = name ;
        this.type = type ;
        this.picByte = picByte;
    }
}
