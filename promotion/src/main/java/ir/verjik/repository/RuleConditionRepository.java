package ir.verjik.repository;

import ir.verjik.entity.RuleCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleConditionRepository extends JpaRepository<RuleCondition, Long> {
}
