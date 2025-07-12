package com.f2f.dao;

import com.f2f.entity.RuleCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleConditionRepository extends JpaRepository<RuleCondition, Long> {
}
