package com.f2f;

//import com.f2f.StorageProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * https://projects.spring.io/spring-security-oauth/docs/oauth2.html
 * https://spring.io/guides/tutorials/spring-boot-oauth2/
 *
 *  //@PropertySource("classpath:mysqlFile.properties")
 *  //@PropertySource("classpath:postgresFile.properties")
 * //@PropertySource("file:src/main/resources/jwt.jks")
 */
@EnableScheduling
@SpringBootApplication
//@PropertySource("file:src/main/resources/application.properties")
//@PropertySource("file:src/main/resources/storage.properties")
//@PropertySource("file:src/main/resources/postgresFile.properties")
//@EnableConfigurationProperties(StorageProperties.class)
public class F2fServerApplication {

    public static void main(String[] args) {
        System.out.println("start f2f server application!");
        SpringApplication.run(F2fServerApplication.class, args);
    }
}
