package com.f2f.security;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.resource.PathResourceResolver;
//
//@Configuration
//public class DisableCorsConfiguration implements WebMvcConfigurer {
////    @Override
////    public void addCorsMappings(CorsRegistry registry) {
////        registry.addMapping("/**")
////                .allowedMethods("HEAD","GET","PUT","POST","DELETE","PATCH")
////                .allowedOrigins("http://localhost:8081")
////                .allowedHeaders("*")
////                .allowCredentials(true)
////                .maxAge(3600);
////    }
//

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

////    @Override
////    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("/images/**")
////                .addResourceLocations("classpath:/images/logo/")
////                .addResourceLocations("classpath:/images/footer/")
////                .addResourceLocations("classpath:/images/icon/")
////                .addResourceLocations("classpath:/images/")
////                .setCachePeriod(300)
////                .resourceChain(true)
////                .addResolver(new PathResourceResolver());
////
////    }
//}

    public class DisableCorsConfiguration {}
//
//@Configuration
//@Profile("develop")
//public class DisableCorsConfiguration{
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("*")
//                        .allowedMethods("*")
//                        .allowedHeaders("*")
//                        .allowCredentials(false);
//            }
//        };
//    }
//
//}
