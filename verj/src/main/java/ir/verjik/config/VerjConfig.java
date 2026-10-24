package ir.verjik.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:f2fc.properties")
public class VerjConfig {
    public VerjConfig(){
        System.out.println("debug: classpath:f2fc.properties --> Constructor");
    }
}
