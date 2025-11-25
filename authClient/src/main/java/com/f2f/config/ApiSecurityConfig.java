package com.f2f.config;

import com.f2f.blacklist.TokenBlacklistService;
import com.f2f.filter.JwtAuthenticationFilter;
import com.f2f.util.JwtUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ApiSecurityConfig {

    private final JwtUtils jwtUtils;
    private final TokenBlacklistService blacklistService;

    public ApiSecurityConfig(JwtUtils jwtUtils, TokenBlacklistService blacklistService) {
        this.jwtUtils = jwtUtils;
        this.blacklistService = blacklistService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        JwtAuthenticationFilter jwtFilter = new JwtAuthenticationFilter(jwtUtils, blacklistService);

        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/public/**", "/health", "/actuator/**","/store/**","/api/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtFilter, org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
