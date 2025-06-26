package com.f2f.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * some interfaces require cross-entity support
 */
@Profile("develop")
@Configuration
public class CustomCorsConfiguration {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);// اجازه ارسال کوکی ها
        corsConfiguration.addAllowedOrigin("http://localhost:8080");
        corsConfiguration.addAllowedOrigin("http://localhost:8081");
        corsConfiguration.addAllowedOrigin("http://localhost:8082");
        corsConfiguration.addAllowedOrigin("http://127.0.0.1:5173");

        //corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("GET");
        corsConfiguration.addAllowedMethod("POST");
        corsConfiguration.addAllowedMethod("DELETE");
        corsConfiguration.addAllowedMethod("OPTIONS");
///        corsConfiguration.addExposedHeader("head1");
///        corsConfiguration.addExposedHeader("Location");
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/oauth/**", corsConfiguration);

        urlBasedCorsConfigurationSource.registerCorsConfiguration("/f/**", corsConfiguration);
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/b/**", corsConfiguration);


        urlBasedCorsConfigurationSource.registerCorsConfiguration("/user/me", corsConfiguration);
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/f2f/**", corsConfiguration);
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/captcha/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
