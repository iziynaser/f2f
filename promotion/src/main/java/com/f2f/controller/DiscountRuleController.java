package com.f2f.controller;

import com.f2f.dto.DiscountRuleRequestDTO;
import com.f2f.entity.DiscountRule;
import com.f2f.service.DiscountRuleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discount-rules")
@RequiredArgsConstructor
public class DiscountRuleController {

    private final DiscountRuleService ruleService;

    @PostMapping
    public ResponseEntity<DiscountRule> createRule(@RequestBody @Valid DiscountRuleRequestDTO dto) {
        DiscountRule created = ruleService.createRule(dto.getRule(), dto.getConditions());
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRule(@PathVariable Long id, @RequestBody @Valid DiscountRuleRequestDTO dto) {
        try {
            DiscountRule updated = ruleService.updateRule(id, dto.getRule(), dto.getConditions());
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<DiscountRule>> getAllRules() {
        return ResponseEntity.ok(ruleService.getAllRules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountRule> getRule(@PathVariable Long id) {
        return ruleService.getRuleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRule(@PathVariable Long id) {
        ruleService.deleteRule(id);
        return ResponseEntity.noContent().build();
    }
}
