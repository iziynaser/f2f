package com.f2f.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:dbc.properties")
public class DbcConfig {

    public DbcConfig() {
        System.out.println("debug: dbc.properties loaded !!");
    }
}
