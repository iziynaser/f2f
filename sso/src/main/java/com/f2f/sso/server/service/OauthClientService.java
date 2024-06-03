package com.f2f.sso.server.service;

//import com.revengemission.sso.oauth2.server.domain.NotImplementException;
//import com.revengemission.sso.oauth2.server.domain.OauthClient;

import com.f2f.domain.NotImplementException;
import com.f2f.domain.OauthClient;

public interface OauthClientService extends CommonServiceInterface<OauthClient> {
    default OauthClient findByClientId(String clientId){
        throw new NotImplementException();
    }
}
