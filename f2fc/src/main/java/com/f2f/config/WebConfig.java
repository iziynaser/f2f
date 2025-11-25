package com.f2f.config;

public class WebConfig{}
//
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Autowired
//    private final AuthInterceptor authInterceptor;
//
//    public WebConfig(AuthInterceptor authInterceptor) {
//        this.authInterceptor = authInterceptor;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//            registry.addInterceptor(authInterceptor)
//                    .addPathPatterns("admin/api/**")  // مسیرهایی که نیاز به احراز دارند
//                    .excludePathPatterns("/public/**").excludePathPatterns("/api/**");
//    }
//
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        System.out.println("WebConfig configurer");
//        configurer.setPathMatcher(new AntPathMatcher());
//    }
//}
