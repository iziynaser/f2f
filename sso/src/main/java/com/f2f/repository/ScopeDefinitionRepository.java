package com.f2f.repository;

import com.f2f.entity.ScopeDefinitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScopeDefinitionRepository extends JpaRepository<ScopeDefinitionEntity, Long> {
    ScopeDefinitionEntity findByScope(String scope);
}
