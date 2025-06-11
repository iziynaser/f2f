package com.f2f;

import com.f2f.repository.OauthClientRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthorizationServerConfig {
    private final OauthClientRepository oauthClientRepository;
    private final PasswordEncoder passwordEncoder ;

    public AuthorizationServerConfig( OauthClientRepository oauthClientRepository){
        this.oauthClientRepository = oauthClientRepository;
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    //providersetting
    //authserversecurityfilterchain
    //registerclientrepository

}
