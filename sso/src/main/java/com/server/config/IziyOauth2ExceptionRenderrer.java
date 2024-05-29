package com.revengemission.sso.oauth2.server.config;

import org.springframework.http.HttpEntity;
import org.springframework.security.oauth2.provider.error.OAuth2ExceptionRenderer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

@Component
public class IziyOauth2ExceptionRenderrer implements OAuth2ExceptionRenderer {

        @Override
        public void handleHttpEntityResponse(HttpEntity<?> responseEntity, ServletWebRequest webRequest) throws Exception {
            System.out.println("Thrown exception");
        }

}
