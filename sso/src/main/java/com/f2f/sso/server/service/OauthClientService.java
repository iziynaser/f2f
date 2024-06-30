package com.f2f.sso.server.service;

import com.f2f.dbc.domain.NotImplementException;
import com.f2f.dbc.domain.OauthClient;
import com.f2f.dbc.service.CommonServiceInterface;

public interface OauthClientService extends CommonServiceInterface<OauthClient> {
    default OauthClient findByClientId(String clientId){
        throw new NotImplementException();
    }
}
