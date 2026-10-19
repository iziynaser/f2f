package ir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
@SpringBootApplication(
        scanBasePackageClasses = {}
        ,
        scanBasePackages = {"ir"}

        )
//@PropertySources({
//        @PropertySource("classpath:application.properties"),
//        @PropertySource("classpath:postgresFile.properties"),
//        @PropertySource("classpath:storage.properties")
//})
public class VerjikServerApplication {

    public static void main(String[] args) {
        System.out.println("start verjik server application!");
        SpringApplication.run(VerjikServerApplication.class, args);
    }

}
