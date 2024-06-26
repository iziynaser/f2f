package com;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableJpaRepositories("com...dao")
@EntityScan("com...dao")
@ComponentScan(value= {"com...service","com...controller"})
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class},
        scanBasePackages = {"com.f2f.security.*","com.f2f.dao.acc.*","com.f2f.dbc.service.*","com.f2f.persistence.*","com.f2f.domain.*","com.f2f.sso.*","com.f2f.controller.*","com.f2f.service.*","com.f2f.config.*","com.f2f.sso.server.config.*"})
@PropertySources({
        @PropertySource(value="classpath:application.properties"),
        @PropertySource(value = "classpath:postgresFile.properties")
})
public class F2fServerApplication {

    public static void main(String[] args) {
        System.out.println("start f2f server application!");
        SpringApplication.run(F2fServerApplication.class, args);
    }
}
