package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "com.f2f.dbc.service.*,com.f2f.persistence.*,com.f2f.domain.*,com.f2f.sso,com.f2f.controller.*,com.f2f.dao.dao.*,com.f2f.service,com.f2f.config,com.f2f.sso.server.config.*")
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},scanBasePackages = "com")
//@ComponentScan("com.f2f.dbc.service,com.f2f.persistence,com.f2f.domain,com.f2f.sso,com.f2f.controller,com.f2f.dao.dao,com.f2f.service,com.f2f.config,com.f2f.sso.server.config")
//@PropertySource("classpath:dbc.properties,sso.properties")
public class F2fServerApplication {

    public static void main(String[] args) {
        System.out.println("start f2f server application!");
        SpringApplication.run(F2fServerApplication.class, args);
    }
}
