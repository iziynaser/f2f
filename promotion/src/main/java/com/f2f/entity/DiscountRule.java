package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.enums.BenefitAction;
import com.f2f.enums.BenefitType;
import com.f2f.enums.DiscountType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "DISCOUNT_RULE")
public class DiscountRule extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Enumerated(EnumType.STRING)
    private BenefitType benefitType; // NEW

    @Enumerated(EnumType.STRING)
    private BenefitAction benefitAction; // NEW

    @Enumerated(EnumType.STRING)
    @Column(name = "DISCOUNT_TYPE")
    private DiscountType discountType; //???

    @Column(name = "DISCOUNT_VALUE")
    private Long discountValue;

    @Column(name = "ACTIVE")
    private Boolean active;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Column(name = "USAGE_LIMIT")
    private Integer usageLimit;

    @OneToMany(mappedBy = "discountRule", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<RuleCondition> conditions = new ArrayList<>();
}
