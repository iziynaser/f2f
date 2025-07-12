package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.enums.DiscountApplyLevel;
import com.f2f.enums.DiscountType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "DISCOUNT")
public class Discount   extends BaseEntity implements Serializable {

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    private String discountName;
    private Long discountValue;

    private LocalDate startDate;
    private LocalDate endDate;

    private boolean active;

    private Long productItemId;
    private Long personId;// person
    private Long categoryId;//category
    private Long brandId ;//brand

    private Integer minQuantity;
    private Integer maxQuantity;

    private Long minTotalAmount;
    private Long maxTotalAmount;

    @Column(name = "origin")
    private String origin; // LUCKY_WHEEL, PROMOTION, SYSTEM, ...

    /*
    برای مشخص کردن اینکه تخفیف در چه سطحی اعمال شود.
    سفارش کامل
    محصول خاص
    برند ....
     */
    @Enumerated(EnumType.STRING)
    private DiscountApplyLevel applyTo;

    private Integer usageLimit ;// تعداد دفعات قابل استفاده از تخفیف

}
