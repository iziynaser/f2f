package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
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
