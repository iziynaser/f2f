package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;


@Entity
@Table(name="PRODUCT_IMAGE")
public class ProductImage extends BaseEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name ;

    @Column(name = "type")
    private String type;

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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Boolean getUserImage() {
        return isUserImage;
    }

    public void setUserImage(Boolean userImage) {
        isUserImage = userImage;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
