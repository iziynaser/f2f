```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
@Configuration
public class WebConfig implements WebMvcConfigurer {

@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
registry
.addResourceHandler("/user/**")
.addResourceLocations("classpath:/public/frontf/");

registry
.addResourceHandler("/admin/**")
.addResourceLocations("classpath:/public/frontb/");
}

@Override
public void addViewControllers(ViewControllerRegistry registry) {
registry.addViewController("/user/**").setViewName("forward:/frontf/index.html");
registry.addViewController("/admin/**").setViewName("forward:/frontb/index.html");
}
}

</body>
</html>
```