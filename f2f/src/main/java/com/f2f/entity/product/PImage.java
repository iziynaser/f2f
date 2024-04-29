package com.f2f.entity.product;

import com.f2f.persistance.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name="PIMAGE")
public class PImage extends BaseEntity {

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

    public PImage(){
        super();
    }

    public PImage(String name,String type,byte[] picByte){
        this.name = name ;
        this.type = type ;
        this.picByte = picByte;
    }

    public Long getId() {
        return id;
    }

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
}
