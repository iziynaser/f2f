package com.f2f.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApiPrefixConfig implements WebMvcConfigurer {

    @Value("${api.prefix:/api}")
    private String apiPrefix;

    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix(
                apiPrefix,
                c -> c.isAnnotationPresent(RequestMapping.class)
        );
    }
}
