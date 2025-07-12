package com.f2f.service;

import com.f2f.dao.DiscountRuleRepository;
import com.f2f.dto.Context;
import com.f2f.entity.DiscountRule;
import com.f2f.entity.RuleCondition;
import com.f2f.engn.RuleEvaluatorFactory;
import com.f2f.enums.DiscountType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import static com.f2f.enums.DiscountType.FIXED;
import static com.f2f.enums.DiscountType.PERCENTAGE;

@Service
public class DiscountEngine {

    private final DiscountRuleRepository discountRuleRepository;

    public DiscountEngine(DiscountRuleRepository discountRuleRepository) {
        this.discountRuleRepository = discountRuleRepository;
    }

    public List<DiscountRule> findApplicableRules(Context context) {
        LocalDate now = context.getRequestDate();
        if (now == null) {
            now = LocalDate.now();
        }
        // فرض بر این است که این متد موجود است و قوانین فعال به همراه شرایطش را برمی‌گرداند
        List<DiscountRule> rules = discountRuleRepository.findActiveRulesWithConditions(now);

        return rules.stream()
                .filter(rule -> isRuleApplicable(rule, context))
                .toList();
    }

    public DiscountRule selectBestDiscount(List<DiscountRule> rules) {
        return rules.stream()
                .max(Comparator.comparingLong(DiscountRule::getDiscountValue))
                .orElse(null);
    }

    public long applyDiscount(long basePrice, DiscountRule rule) {
        if (rule == null) return basePrice;

        DiscountType type = rule.getDiscountType();
        return switch (type) {
            case PERCENTAGE -> basePrice - ((basePrice * rule.getDiscountValue()) / 100);
            case FIXED -> Math.max(0, basePrice - rule.getDiscountValue());
            default -> basePrice;  // اگر enum های بیشتری دارید یا حالت پیش‌فرض
        };
    }

    private boolean isRuleApplicable(DiscountRule rule, Context context) {
        LocalDate now = context.getRequestDate();
        if (!rule.isActive()) return false;
        if (rule.getStartDate() != null && now.isBefore(rule.getStartDate())) return false;
        if (rule.getEndDate() != null && now.isAfter(rule.getEndDate())) return false;

        for (RuleCondition condition : rule.getConditions()) {
            if (!evaluateCondition(condition, context)) {
                return false;
            }
        }
        return true;
    }

    private boolean evaluateCondition(RuleCondition condition, Context context) {
        Object contextValue = getContextValue(condition.getField(), context);
        return RuleEvaluatorFactory.evaluate(condition, contextValue);
    }

    private Object getContextValue(String field, Context context) {
        return switch (field) {
            case "productItemId" -> context.getProductItemId();
            case "personId" -> context.getPersonId();
            case "brandId" -> context.getBrandId();
            case "categoryId" -> context.getCategoryId();
            case "geoLocation" -> context.getGeoLocation();
            case "quantity" -> context.getQuantity();
            case "totalAmount" -> context.getTotalAmount();
            case "requestDate" -> context.getRequestDate();
            default -> null;
        };
    }
}
