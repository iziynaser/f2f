package com.f2f.sso.server.service.impl;

import com.f2f.domain.NotImplementException;
import com.f2f.domain.ScopeDefinition;
import com.f2f.persistence.entity.ScopeDefinitionEntity;
import com.f2f.persistence.repository.ScopeDefinitionRepository;
import com.f2f.sso.server.service.ScopeDefinitionService;
import com.github.dozermapper.core.Mapper;
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
