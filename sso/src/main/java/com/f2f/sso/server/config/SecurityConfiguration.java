package com.f2f.sso.server.config;

import com.f2f.dbc.domain.RoleEnum;
import com.f2f.sso.server.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${oauth2.granttype.password.captcha:false}")
    private boolean passwordCaptcha;

    @Autowired
    CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Autowired
    CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    CustomAccessDeniedHandler customAccessDeniedHandler;

    @Autowired
    AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource;

    @Autowired
    CaptchaService captchaService;

    @Autowired
    UserDetailsService userService;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider(userService, passwordEncoder(), captchaService, passwordCaptcha);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/assets/**");
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers("/favicon.ico", "/signIn", "/signUp", "/security_check", "/404",
                        "/captcha/**", "/user/me", "/f2f/storage/images/**", "/images/**", "/static/**", "/fonts/**",
                        "/f2f/products/list").permitAll()
                .mvcMatchers("/oauth/signUp").permitAll()
                .mvcMatchers("/management/**").hasAnyAuthority(RoleEnum.ROLE_SUPER.name())
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().csrf().disable()
                .addFilterBefore(new CustomFilter(), UsernamePasswordAuthenticationFilter.class); // اضافه کردن فیلتر سفارشی
    }

    // فیلتر سفارشی که درخواست‌هایی که باید فیلتر شوند را بررسی می‌کند
    public class CustomFilter extends OncePerRequestFilter {

        @Override
        protected void doFilterInternal(HttpServletRequest request, javax.servlet.http.HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            // بررسی اینکه آیا درخواست باید فیلتر شود یا نه
            if (shouldNotFilter(request)) {
                // اگر درخواست نباید فیلتر شود، ادامه می‌دهیم
                filterChain.doFilter(request, response);
            } else {
                // در غیر این صورت، فیلتر را اعمال می‌کنیم
                filterChain.doFilter(request, response);
            }
        }

        // پیاده‌سازی متد shouldNotFilter که شرایط خاصی را برای درخواست‌ها بررسی می‌کند
        protected boolean shouldNotFilter(HttpServletRequest request) {
            // در اینجا می‌توانید شرایط خاصی را برای درخواست‌هایی که نباید فیلتر شوند تعریف کنید
            String requestUri = request.getRequestURI();
            return requestUri.startsWith("/public") || requestUri.contains("/favicon.ico") || requestUri.contains("/f2f/products/list");  // مثال: درخواست‌هایی که با "/public" شروع می‌شوند یا "/favicon.ico" نباید فیلتر شوند
        }
    }
}
