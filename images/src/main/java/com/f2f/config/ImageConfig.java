package com.f2f.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.File;

@Configuration
@PropertySource("classpath:image.properties")
public class ImageConfig {

    @PostConstruct
    public void init() {
        String publicImgDir = System.getProperty("public.image.dir") + "/public/images/";
        File dir = new File(publicImgDir);
        if (!dir.exists()) {
            boolean created = dir.mkdirs();
            if(created) {
               System.out.println("Image directory created");
            }else {
                System.out.println("Image directory not created");
            }
        }
    }

}
