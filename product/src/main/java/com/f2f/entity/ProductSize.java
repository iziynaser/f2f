package com.f2f.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT_SIZE")
public class ProductSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SIZE_NAME")
    private String name ;

    @Column(name ="SIZE_VALUE")
    private String value ;
}
