package com.f2f.config;

import com.f2f.filter.ExternalAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Profile("dev")
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${api.prefix:/api}")
    private String apiPrefix;

    @Autowired
    private ExternalAuthFilter externalAuthFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //http.csrf().disable();

        http.cors().and().authorizeHttpRequests()
                // مسیرهای کاملا عمومی
                .requestMatchers( "/**").permitAll()

                // سایر مسیرها
                .anyRequest().authenticated();

        http.addFilterBefore(externalAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
