package com.f2f.entity;

 
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "StockBatches")
public class StockBatches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ProductItem productItems;

    private LocalDate entryDate;
    private LocalDate arrivalDate;

    private LocalDate manufactureDate;
    private LocalDate expiryDate;
    private Integer quantity;
    private Integer sold;
    private Integer remaining;
    private Boolean available;
    private LocalDate outOfStockDate;

}
