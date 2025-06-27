package com.f2f.entity.invoice;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.entity.InvoiceType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name="INVOICE")
public class Invoice extends BaseEntity implements Serializable {

    @Column(name = "invoice_number", unique = true, nullable = false)
    private String invoiceNumber;

    @Column(name = "INVOICE_CODE")
    private String invoiceCode;

    @Column(name = "invoice_date")
    private LocalDateTime invoiceDate;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "payment_method")
    private String paymentMethod;  // مثلا: کارت اعتباری، نقد، انتقال بانکی و ...

    @Column(name = "payment_status")
    private String paymentStatus;  // مثلا: پرداخت شده، در انتظار پرداخت و ...

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "total_amount")
    private Long totalAmount;

    @Column(name = "paid_amount")
    private Long paidAmount;

    @Column(name = "remarks")
    private String remarks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reference_invoice_id")
    private Invoice referenceInvoice;

//    @OneToOne
//    @JoinColumn(name = "CREATOR_PERSON_ID")
    private Long creatorPersonId;

//    @OneToOne
//    @JoinColumn(name = "FROM_PERSON_ID")
    private Long fromPersonId;

//    @OneToOne
//    @JoinColumn(name = "TO_PERSON_ID")
    private Long toPersonId;

    // ایتم‌های فاکتور
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<InvoiceItem> items = new HashSet<>();

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceStatus> invoiceStatuses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_type")
    private InvoiceType invoiceType;// مثلا: PURCHASE, SALES, RETURN, PROFORMA و ...

//    // ارتباط با سفارش (اختیاری)
//    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Long orderId;

//    @PostPersist
//    private void createInvoiceCodeAutomatically() {
//        String inCode = this.toPerson.getId() + "." + this.fromPerson.getId() + "." + this.getDate() + "." + this.getId();
//        setInvoiceCode(inCode);
//    }

//    public Invoice( String message, String description, PersonEntity creatorPerson, Person fromPerson, Person toPerson, List<InvoiceStatus> invoiceStatuses, String invoiceType) {
//
//        this.message = message;
//        this.description = description;
//        this.creatorPerson = creatorPerson;
//        this.fromPerson = fromPerson;
//        this.toPerson = toPerson;
//        //this.invoiceItems = invoiceItems;
//        this.invoiceStatuses = invoiceStatuses;
//        this.invoiceType = invoiceType;
//    }
}