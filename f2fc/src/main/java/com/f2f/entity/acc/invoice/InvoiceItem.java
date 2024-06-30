package com.f2f.entity.acc.invoice;

import com.f2f.entity.inventory.Inventory;
import com.f2f.entity.product.Product;
import com.f2f.entity.product.ProductFeatureItem;
import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "INVOICE_ITEM")
public class InvoiceItem extends BaseEntity implements Serializable {

    @Column(name = "SEQ_ID")
    private Integer sequenceId;

    @Column(name = "TAXABLE_FLAG")
    private Boolean isTaxable;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "AMOUNT")
    private Integer amount ;

    @Column(name = "DESCRIPTION")
    private String description ;

    @ManyToOne
    @JoinColumn(name = "INVOICE_ID")
    private Invoice invoice;

    @OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @OneToOne
    @JoinColumn(name="INVENTORY_ID")
    private Inventory inventory;

    @OneToOne
    @JoinColumn(name = "PRODUCT_FEATURE_ID")
    private ProductFeatureItem productFeatureItem;

    @Column(name = "INVOICE_ITEM_TYPE" )
    private String invoiceItemType;

    public InvoiceItem() {
    }

    public InvoiceItem(Integer sequenceId, Boolean isTaxable, Integer quantity, Integer amount, String description, Invoice invoice, Product product, Inventory inventory, ProductFeatureItem productFeatureItem, String invoiceItemType) {
        this.sequenceId = sequenceId;
        this.isTaxable = isTaxable;
        this.quantity = quantity;
        this.amount = amount;
        this.description = description;
        this.invoice = invoice;
        this.product = product;
        this.inventory = inventory;
        this.productFeatureItem = productFeatureItem;
        this.invoiceItemType = invoiceItemType;
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }


    public Integer getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(Integer sequenceId) {
        this.sequenceId = sequenceId;
    }

    public Boolean getTaxable() {
        return isTaxable;
    }

    public void setTaxable(Boolean taxable) {
        isTaxable = taxable;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public ProductFeatureItem getProductFeatureItem() {
        return productFeatureItem;
    }

    public void setProductFeatureItem(ProductFeatureItem productFeatureItem) {
        this.productFeatureItem = productFeatureItem;
    }

    public String getInvoiceItemType() {
        return invoiceItemType;
    }

    public void setInvoiceItemType(String invoiceItemType) {
        this.invoiceItemType = invoiceItemType;
    }
}
