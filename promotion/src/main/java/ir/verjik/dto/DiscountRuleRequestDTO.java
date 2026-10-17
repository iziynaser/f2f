package ir.verjik.dto;

import ir.verjik.entity.DiscountRule;
import ir.verjik.entity.RuleCondition;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DiscountRuleRequestDTO {
    private DiscountRule rule;
    private List<RuleCondition> conditions;
}
