package com.f2f.service;

import com.f2f.dao.DiscountRuleRepository;
import com.f2f.dto.DiscountDTO;
import com.f2f.dto.Context;
import com.f2f.entity.DiscountRule;
import com.f2f.entity.RuleCondition;
import com.f2f.port.DiscountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountAdapter implements DiscountPort {

    private final DiscountRuleRepository discountRuleRepository;

    @Override
    public List<DiscountDTO> findActiveDiscounts(Long productItemId, Long personId, LocalDateTime now) {
        Context context = new Context();
        context.setProductItemId(productItemId);
        context.setPersonId(personId);
        context.setRequestDate(now.toLocalDate());

        // تخفیف‌های فعال را از دیتابیس بگیر
        List<DiscountRule> rules = discountRuleRepository.findActiveRulesWithConditions(now.toLocalDate());

        // فیلتر قوانین معتبر بر اساس Context
        return rules.stream()
                .filter(rule -> isApplicable(rule, context))
                .map(rule -> {
                    DiscountDTO dto = new DiscountDTO();
                    //dto.setId(rule.getId());
                    dto.setDiscountName(rule.getName());
                    dto.setDiscountType(rule.getDiscountType());
                    dto.setDiscountValue(rule.getDiscountValue());
                    return dto;
                })
                .toList();
    }

    private boolean isApplicable(DiscountRule rule, Context context) {
        if (!Boolean.TRUE.equals(rule.getActive())) return false;

        if (rule.getStartDate() != null && context.getRequestDate().isBefore(rule.getStartDate())) return false;
        if (rule.getEndDate() != null && context.getRequestDate().isAfter(rule.getEndDate())) return false;

        for (RuleCondition condition : rule.getConditions()) {
            Object ctxVal = getContextValue(condition.getField(), context);
            if (!com.f2f.engn.RuleEvaluatorFactory.evaluate(condition, ctxVal)) {
                return false;
            }
        }
        return true;
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
