package com.f2f.persistence.repository;

import com.f2f.persistence.entity.ScopeDefinitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScopeDefinitionRepository extends JpaRepository<ScopeDefinitionEntity, Long> {
    ScopeDefinitionEntity findByScope(String scope);
}
