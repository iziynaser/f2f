package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "RULE_CONDITION")
public class RuleCondition extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DISCOUNT_RULE_ID")
    private DiscountRule discountRule;

    @Column(name = "FIELD")
    private String field; // quantity, geoLocation, brandId, personid,deliverytime,etc.

    @Column(name = "OPERATOR")
    private String operator; // EQ, GT, GTE, IN, BETWEEN , CONTAINS , ...

    @Column(name = "VALUE")
    private String value;

    @Column(name = "VALUE_TYPE")
    private String valueType; // STRING, NUMBER, ENUM, DATE , TIME , BOOLEAN
}
