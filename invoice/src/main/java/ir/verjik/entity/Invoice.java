package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import ir.verjik.enums.PaymentMethod;
import ir.verjik.enums.PaymentStatus;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method",length = 20)
    private PaymentMethod paymentMethod;  // مثلا: کارت اعتباری، نقد، انتقال بانکی و ...

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status",length = 20)
    private PaymentStatus paymentStatus;  // مثلا: پرداخت شده، در انتظار پرداخت و ...

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "total_amount")
    private Long  totalAmount;

    @Column(name = "paid_amount")
    private Long paidAmount;

    @Column(name = "remarks")
    private String remarks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reference_invoice_id")
    private Invoice referenceInvoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR_PERSON_ID")
    private PersonEntity creatorPerson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FROM_PERSON_ID")
    private PersonEntity fromPerson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TO_PERSON_ID")
    private PersonEntity toPerson;

    // ایتم‌های فاکتور
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<InvoiceItem> items = new HashSet<>();

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceStatus> invoiceStatuses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_type")
    private InvoiceType invoiceType;// مثلا: PURCHASE, SALES, RETURN, PROFORMA و ...

    @Column(name = "order_id")
    private Long orderId;

}
