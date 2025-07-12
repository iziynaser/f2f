package com.f2f.dao;

import com.f2f.entity.DiscountRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DiscountRuleRepository extends JpaRepository<DiscountRule, Long> {

    @Query("SELECT DISTINCT r FROM DiscountRule r LEFT JOIN FETCH r.conditions WHERE r.active = true AND " +
            "(r.startDate IS NULL OR r.startDate <= :now) AND " +
            "(r.endDate IS NULL OR r.endDate >= :now)")
    List<DiscountRule> findActiveRulesWithConditions(@Param("now") LocalDate now);
}
