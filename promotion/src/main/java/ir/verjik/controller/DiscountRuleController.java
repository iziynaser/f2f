package ir.verjik.controller;

import ir.verjik.dto.DiscountRuleRequestDTO;
import ir.verjik.entity.DiscountRule;
import ir.verjik.service.DiscountRuleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discount-rules")
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
