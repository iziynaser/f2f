package com.f2f.entity.product;

import javax.persistence.*;
import java.time.LocalDate;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductItem getProductItems() {
        return productItems;
    }

    public void setProductItems(ProductItem productItems) {
        this.productItems = productItems;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public LocalDate getOutOfStockDate() {
        return outOfStockDate;
    }

    public void setOutOfStockDate(LocalDate outOfStockDate) {
        this.outOfStockDate = outOfStockDate;
    }
}
