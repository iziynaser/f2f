package com.f2f.sso.server.service;

//import com.revengemission.sso.oauth2.server.domain.NotImplementException;
//import com.revengemission.sso.oauth2.server.domain.ScopeDefinition;

import com.f2f.domain.NotImplementException;
import com.f2f.domain.ScopeDefinition;

public interface ScopeDefinitionService extends CommonServiceInterface<ScopeDefinition> {
    default ScopeDefinition findByScope(String scope) throws NotImplementException {
        throw new NotImplementException();
    }
}
