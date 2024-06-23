package com.f2f.sso.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sso.properties")
public class SsoConfig {
    public SsoConfig(){
        System.out.println("debug: classpath:sso.properties --> Constructor");
    }
}
