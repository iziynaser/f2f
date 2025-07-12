package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class StockIn extends BaseEntity {

    //ManyToOne
    private Long productItemId;

    @ManyToOne
    private Warehouse warehouse;

    private int quantity;// تعداد

    private BigDecimal purchasePrice;// قیمت واحد خرید

    private LocalDate purchaseDate;

    private LocalDateTime stockInDate ;

    private int supplierId ;

    private String referenceNumber ; // faktor ya resid

}
