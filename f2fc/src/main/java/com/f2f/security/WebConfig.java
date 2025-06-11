package com.f2f.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // افزودن CORS برای تمام مسیرها
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8081",
                        "http://127.0.0.1:5173") // اجازه دسترسی به دامنه Vue.js
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // متدهای مجاز
                .allowedHeaders("*")  // مجاز کردن تمام هدرها
                .allowCredentials(true);  // اجازه ارسال کوکی‌ها
    }
}
