package com;

import com.f2f.config.CustomCorsConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
//@ComponentScan(
//        //basePackageClasses={StorageProperties.class , CustomCorsConfiguration.class}
//        basePackageClasses={CustomCorsConfiguration.class}
//        ,
//        basePackages= {"com.f2f.dbc.persistence.entity","com.f2f.entity","com.f2f.dao","com.f2f.mapper",
//                       "com.f2f.controller","com.f2f.controller","com.f2f","com.f2f.service",
//                       "com.f2f.config","com.f2f.scanner"}
//        )
@SpringBootApplication(
        scanBasePackageClasses = {}
        ,
        scanBasePackages = {"com.f2f"}

        )
@PropertySources({
        @PropertySource(value="classpath:application.properties"),
        @PropertySource(value = "classpath:postgresFile.properties"),
        @PropertySource(value = "classpath:storage.properties")
})

public class F2fServerApplication{

    public static void main(String[] args) {
        System.out.println("start f2f server application!");
        SpringApplication.run(F2fServerApplication.class, args);
    }

}
