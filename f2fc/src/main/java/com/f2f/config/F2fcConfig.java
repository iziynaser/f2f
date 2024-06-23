package com.f2f.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:f2fc.properties")
public class F2fcConfig {
    public F2fcConfig(){
        System.out.println("debug: classpath:f2fc.properties --> Constructor");
    }
}
