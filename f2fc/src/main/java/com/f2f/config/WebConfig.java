package com.f2f.config;

import com.f2f.security.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private final AuthInterceptor authInterceptor;

    public WebConfig(AuthInterceptor authInterceptor) {
        this.authInterceptor = authInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(authInterceptor)
                    .addPathPatterns("admin/api/**")  // مسیرهایی که نیاز به احراز دارند
                    .excludePathPatterns("/public/**");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        System.out.println("WebConfig configurer");
        configurer.setPathMatcher(new AntPathMatcher());
    }
}
