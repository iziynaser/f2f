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

@Service
public class DiscountEngine {

    private final DiscountRuleRepository discountRuleRepository;

    public DiscountEngine(DiscountRuleRepository discountRuleRepository) {
        this.discountRuleRepository = discountRuleRepository;
    }

    /**
     * پیدا کردن تمام قوانین قابل اعمال بر اساس کانتکست
     */
    public List<DiscountRule> findApplicableRules(Context context) {
        LocalDate now = context.getRequestDate() != null ? context.getRequestDate() : LocalDate.now();
        List<DiscountRule> rules = discountRuleRepository.findActiveRulesWithConditions(now);

        return rules.stream()
                .filter(rule -> isRuleApplicable(rule, context))
                .toList();
    }

    /**
     * پیدا کردن بهترین تخفیف مالی (فقط از نوع PERCENTAGE یا FIXED)
     */
    public DiscountRule selectBestDiscount(List<DiscountRule> rules) {
        return rules.stream()
                .filter(rule -> isFinancial(rule.getDiscountType()))
                .max(Comparator.comparingLong(DiscountRule::getDiscountValue))
                .orElse(null);
    }

    /**
     * اعمال تخفیف بر قیمت پایه
     */
    public long applyDiscount(long basePrice, DiscountRule rule) {
        if (rule == null) return basePrice;

        DiscountType type = rule.getDiscountType();
        return switch (type) {
            case PERCENTAGE -> basePrice - ((basePrice * rule.getDiscountValue()) / 100);
            case FIXED -> Math.max(0, basePrice - rule.getDiscountValue());
            default -> basePrice; // تخفیف‌های غیرمالی قیمت را تغییر نمی‌دهند
        };
    }

    /**
     * بررسی اینکه یک Rule قابل اعمال بر Context هست یا نه
     */
    private boolean isRuleApplicable(DiscountRule rule, Context context) {
        LocalDate now = context.getRequestDate();
        if (!Boolean.TRUE.equals(rule.getActive())) return false;
        if (rule.getStartDate() != null && now.isBefore(rule.getStartDate())) return false;
        if (rule.getEndDate() != null && now.isAfter(rule.getEndDate())) return false;

        for (RuleCondition condition : rule.getConditions()) {
            Object contextValue = getContextValue(condition.getField(), context);
            if (!RuleEvaluatorFactory.evaluate(condition, contextValue)) {
                return false;
            }
        }

        return true;
    }

    /**
     * نگاشت فیلدهای کانتکست به RuleCondition برای ارزیابی
     */
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
            case "deliveryTime" -> context.getDeliveryTime(); // در صورت استفاده
            default -> null;
        };
    }

    /**
     * بررسی اینکه نوع تخفیف مالی است یا نه
     */
    private boolean isFinancial(DiscountType type) {
        return type == DiscountType.FIXED || type == DiscountType.PERCENTAGE;
    }
}
