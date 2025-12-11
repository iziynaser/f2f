package com.f2f.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Profile("dev")
@Configuration
public class CustomCorsConfiguration {

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public CorsFilter corsFilter() {

        CorsConfiguration cors = new CorsConfiguration();
        cors.setAllowCredentials(true);

        // اجازه تمام فرانت‌های لوکال
        cors.addAllowedOriginPattern("http://localhost:*");
        cors.addAllowedOriginPattern("http://127.0.0.1:*");
        cors.addAllowedOriginPattern("http://192.168.*:*");

        cors.addAllowedHeader("*");
        cors.addAllowedMethod("*");

        // هدرهای مهم برای SPA
        cors.addExposedHeader("Authorization");
        cors.addExposedHeader("Location");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cors);   // ← تمام مسیرها

        return new CorsFilter(source);
    }
}
