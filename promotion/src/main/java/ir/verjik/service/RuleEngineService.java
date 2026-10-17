package ir.verjik.service;

import ir.verjik.dto.DiscountContext;
import ir.verjik.entity.DiscountRule;
import ir.verjik.entity.RuleCondition;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;

@Service
public class RuleEngineService {

    public boolean evaluateRule(DiscountRule rule, DiscountContext context) {
        for (RuleCondition condition : rule.getConditions()) {
            if (!evaluateCondition(condition, context)) {
                return false;
            }
        }
        return true;
    }

    private boolean evaluateCondition(RuleCondition condition, DiscountContext ctx) {
        String field = condition.getField();
        String operator = condition.getOperator();
        String value = condition.getValue();

        return switch (field) {
            case "quantity" -> {
                int q = ctx.getQuantity();
                int v = Integer.parseInt(value);
                yield switch (operator) {
                    case "GT" -> q > v;
                    case "GTE" -> q >= v;
                    case "EQ" -> q == v;
                    case "LT" -> q < v;
                    default -> false;
                };
            }
            case "brandId" -> ctx.getBrandId() != null && ctx.getBrandId().toString().equals(value);
            case "geoLocation" -> ctx.getGeoLocation() != null && ctx.getGeoLocation().equalsIgnoreCase(value);
            case "dayOfWeek" -> {
                DayOfWeek today = ctx.getRequestDate().getDayOfWeek();
                yield today.name().equalsIgnoreCase(value);
            }
            default -> false;
        };
    }

    public long applyRuleDiscount(DiscountRule rule, long basePrice) {
        if (rule == null) return basePrice;

        switch (rule.getDiscountType()) {
            case PERCENTAGE:
                return basePrice - ((basePrice * rule.getDiscountValue()) / 100);
            case FIXED:
                return basePrice - rule.getDiscountValue();
            default:
                return basePrice;
        }
    }

}
