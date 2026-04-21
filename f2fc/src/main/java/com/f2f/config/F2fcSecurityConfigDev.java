package com.f2f.config;

import com.f2f.blacklist.TokenBlacklistService;
import com.f2f.filter.JwtAuthenticationFilter;
import com.f2f.util.JwtUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@Order(1) // اولویت بالا برای مسیرهای /api/store/**
@Profile("dev")
public class F2fcSecurityConfigDev {

    @Bean
    public SecurityFilterChain f2fcFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll()
                        .anyRequest().permitAll()
                );
        return http.build();
    }
}
