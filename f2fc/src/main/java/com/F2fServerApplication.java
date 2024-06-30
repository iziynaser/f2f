package com;

import com.f2f.dbc.service.UserAccountDbcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@ComponentScan(basePackageClasses={UserAccountDbcService.class})
@SpringBootApplication(scanBasePackages = {"com.f2f.dbc.service","com.f2f.dbc.persistence.entity","com.f2f.service","com.f2f.controller"}
        ,scanBasePackageClasses = UserAccountDbcService.class)
@PropertySources({
        @PropertySource(value="classpath:application.properties"),
        @PropertySource(value = "classpath:postgresFile.properties"),
        @PropertySource(value = "classpath:storage.properties")
})
public class F2fServerApplication {

    public static void main(String[] args) {
        System.out.println("start f2f server application!");
        SpringApplication.run(F2fServerApplication.class, args);
    }
}
