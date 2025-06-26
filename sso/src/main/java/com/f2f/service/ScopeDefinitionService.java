package com.f2f.service;

import com.f2f.dbc.domain.NotImplementException;
import com.f2f.dbc.domain.ScopeDefinition;
import com.f2f.dbc.service.CommonServiceInterface;

public interface ScopeDefinitionService extends CommonServiceInterface<ScopeDefinition> {
    default ScopeDefinition findByScope(String scope) throws NotImplementException {
        throw new NotImplementException();
    }
}
