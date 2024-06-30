package com.f2f.dbc.persistence.repository;

import com.f2f.dbc.persistence.entity.ScopeDefinitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScopeDefinitionRepository extends JpaRepository<ScopeDefinitionEntity, Long> {
    ScopeDefinitionEntity findByScope(String scope);
}
