package com.f2f.service;

import com.f2f.dao.DiscountRuleRepository;
import com.f2f.dao.RuleConditionRepository;
import com.f2f.entity.DiscountRule;
import com.f2f.entity.RuleCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiscountRuleService {

    private final DiscountRuleRepository discountRuleRepository;
    private final RuleConditionRepository ruleConditionRepository;

    public DiscountRule createRule(DiscountRule rule, List<RuleCondition> conditions) {
        rule.setConditions(new ArrayList<>()); // ابتدا پاک شود
        DiscountRule savedRule = discountRuleRepository.save(rule);

        for (RuleCondition condition : conditions) {
            condition.setDiscountRule(savedRule);
            ruleConditionRepository.save(condition);
            savedRule.getConditions().add(condition);
        }

        return savedRule;
    }

    public List<DiscountRule> getAllRules() {
        return discountRuleRepository.findAll();
    }

    public Optional<DiscountRule> getRuleById(Long id) {
        return discountRuleRepository.findById(id);
    }

    public void deleteRule(Long id) {
        discountRuleRepository.deleteById(id);
    }

    public DiscountRule updateRule(Long id, DiscountRule updatedRule, List<RuleCondition> newConditions) {
        Optional<DiscountRule> existing = discountRuleRepository.findById(id);
        if (existing.isEmpty()) throw new RuntimeException("Rule not found");

        DiscountRule rule = existing.get();

        rule.setName(updatedRule.getName());
        rule.setDescription(updatedRule.getDescription());
        rule.setDiscountType(updatedRule.getDiscountType());
        rule.setDiscountValue(updatedRule.getDiscountValue());
        rule.setStartDate(updatedRule.getStartDate());
        rule.setEndDate(updatedRule.getEndDate());
        rule.setUsageLimit(updatedRule.getUsageLimit());
        rule.setActive(updatedRule.isActive());

        // حذف شرط‌های قدیمی و ذخیره جدید
        ruleConditionRepository.deleteAll(rule.getConditions());
        rule.setConditions(new ArrayList<>());

        for (RuleCondition condition : newConditions) {
            condition.setDiscountRule(rule);
            ruleConditionRepository.save(condition);
            rule.getConditions().add(condition);
        }

        return discountRuleRepository.save(rule);
    }
}
