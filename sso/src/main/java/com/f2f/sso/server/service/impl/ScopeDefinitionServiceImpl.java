package com.f2f.sso.server.service.impl;

import com.f2f.dbc.domain.NotImplementException;
import com.f2f.dbc.domain.ScopeDefinition;
import com.f2f.dbc.persistence.entity.ScopeDefinitionEntity;
import com.f2f.dbc.persistence.repository.ScopeDefinitionRepository;
import com.f2f.sso.server.service.ScopeDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScopeDefinitionServiceImpl implements ScopeDefinitionService {

    @Autowired
    ScopeDefinitionRepository scopeDefinitionRepository;

//    @Autowired
//    Mapper dozerMapper;

    @Override
    public ScopeDefinition findByScope(String scope) throws NotImplementException {
        ScopeDefinitionEntity scopeDefinitionEntity = scopeDefinitionRepository.findByScope(scope);
        if (scopeDefinitionEntity != null) {
            //return dozerMapper.map(scopeDefinitionEntity, ScopeDefinition.class);
            return copy(scopeDefinitionEntity);
        } else {
            return null;
        }
    }

    public ScopeDefinition copy( ScopeDefinitionEntity scopeDefinitionEntity){
        ScopeDefinition scopeDefinition = new ScopeDefinition();
        scopeDefinition.setScope(scopeDefinitionEntity.getScope());
        scopeDefinition.setDefinition(scopeDefinitionEntity.getDefinition());
        return scopeDefinition;
    }
}
