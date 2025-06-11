package com.f2f.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.stereotype.Component;
//
//@Configuration
//@EnableWebSecurity
//@Component("disableSecurityConfigurationBean")
//@Order(value=Ordered.HIGHEST_PRECEDENCE)
//@Profile("develop")
//public class DisableSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers("/**");
//    }
//
//    //OR - Use any one of these two methods
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .authorizeRequests()
//                .antMatchers("/***")
//                .permitAll();
//    }
//}

//class DisableSecurityConfiguration{}

//
//@Configuration
//@Profile("develop")
//public class DisableSecurityConfiguration{
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.cors(cors -> cors.configurationSource(
//                request -> {
//                 CorsConfiguration corsConfiguration = new CorsConfiguration();
//                 corsConfiguration.setAllowedOrigins(List.of("*"));
//                 corsConfiguration.setAllowedMethods(List.of("*"));
//                 corsConfiguration.setAllowedHeaders(List.of("*"));
//                 corsConfiguration.setAllowCredentials(false);
//                 return corsConfiguration;
//                })).csrf(csrf -> csrf.disable());
//        return http.build();
//    }
//}

public class DisableSecurityConfiguration{}