package ir.verjik.config;

import ir.verjik.blacklist.TokenBlacklistService;
import ir.verjik.filter.JwtAuthenticationFilter;
import ir.verjik.util.JwtUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@Order(1) // اولویت بالا برای مسیرهای /api/store/**
@Profile("prod")
public class VerjSecurityConfig {

    private final JwtUtils jwtUtils;
    private final TokenBlacklistService blacklistService;

    public VerjSecurityConfig(JwtUtils jwtUtils, TokenBlacklistService blacklistService) {
        this.jwtUtils = jwtUtils;
        this.blacklistService = blacklistService;
    }

    @Bean
    public SecurityFilterChain f2fcFilterChain(HttpSecurity http) throws Exception {

        JwtAuthenticationFilter jwtFilter = new JwtAuthenticationFilter(jwtUtils, blacklistService);

        http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        // مسیرهای عمومی بدون JWT
                        .requestMatchers("/public/**", "/health", "/actuator/**").permitAll()
                        .requestMatchers("/api/store/products/**").permitAll() // مسیر عمومی محصولات

                        // مسیرهای حساس که نیاز به JWT دارند
                        .requestMatchers(
                                "/api/store/profile/**",
                                "/api/store/cart/**",
                                "/api/store/checkout/**",
                                "/api/store/order/**"
                        ).authenticated()

                        // سایر مسیرهای /api/store بدون JWT
                        .requestMatchers("/api/store/**").permitAll()

                        // سایر مسیرها آزاد
                        .anyRequest().permitAll()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
