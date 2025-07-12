package com.f2f.dto;

import com.f2f.entity.DiscountRule;
import com.f2f.entity.RuleCondition;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DiscountRuleRequestDTO {
    private DiscountRule rule;
    private List<RuleCondition> conditions;
}
