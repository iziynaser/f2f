package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "stock_in")
public class StockIn extends BaseEntity {

    //ManyToOne
    @Column(name = "product_item_id")
    private Long productItemId;

    @ManyToOne
    private Warehouse warehouse;

    @Column(name = "quantity")
    private Integer quantity;// تعداد

    @Column(name = "purchase_price")
    private BigDecimal purchasePrice;// قیمت واحد خرید

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "stockin_date")
    private LocalDateTime stockInDate ;

    @Column(name = "supplier_id")
    private Integer supplierId ;

    @Column(name = "reference_number")
    private String referenceNumber ; // faktor ya resid

}
