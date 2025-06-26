package com.f2f.config;

import com.f2f.dbc.domain.RoleEnum;
import com.f2f.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Value("${oauth2.granttype.password.captcha:false}")
    private boolean passwordCaptcha;

    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Autowired
    private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource;

    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private UserDetailsService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider(userService, passwordEncoder(), captchaService, passwordCaptcha);
    }

    @Bean(name = "authenticationManagerBean")
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(authenticationProvider())
                .build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .mvcMatchers("/favicon.ico", "/signIn", "/signUp", "/security_check", "/404",
                                "/captcha/**", "/user/me", "/f2f/storage/images/**", "/images/**", "/static/**", "/fonts/**",
                                "/f2f/products/list").permitAll()
                        .mvcMatchers("/oauth/signUp").permitAll()
                        .mvcMatchers("/management/**").hasAuthority(RoleEnum.ROLE_SUPER.name())
                        .anyRequest().authenticated()
                )
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(new CustomFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // مشابه قبلی؛ فیلتر سفارشی
    public class CustomFilter extends OncePerRequestFilter {
        @Override
        protected void doFilterInternal(HttpServletRequest request,
                                        javax.servlet.http.HttpServletResponse response,
                                        FilterChain filterChain) throws ServletException, IOException {
            if (shouldNotFilter(request)) {
                filterChain.doFilter(request, response);
            } else {
                // اینجا می‌تونی JWT رو چک کنی یا کپچا و هر منطق دیگه‌ای که لازمه
                filterChain.doFilter(request, response);
            }
        }

        protected boolean shouldNotFilter(HttpServletRequest request) {
            String requestUri = request.getRequestURI();
            return requestUri.startsWith("/public")
                    || requestUri.contains("/favicon.ico")
                    || requestUri.contains("/f2f/products/list");
        }
    }
}
