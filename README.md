# f2fCore
### 
F2fCore is a small a Spring boot application 
it is project base learning(PBL) for SpringBoot and Java.

### usage 
for practical use,its better to use  the f2f application.this app is not recommended.

### parts
this app consist of the following parts:
1. login
2. content
3. hr
4. accounting
5. warehouse
6. portal
7. report

the resources I used in this app are listed below as far as i can remember:
- ### References of this app
1. https://attacomsian.com/blog/spring-jpa-specification
2. https://ofbiz.apache.org
3. https://github.com/iziynaser/oauth2-server
4. https://github.com/iziynaser/wallride
## frameworks


##github


##the tools used for developing and debug
1. visual studio code
2. intellij community edtion
3. json view pro (plugin for chrome/firefox)

##upload images
برای اپلود تصاویر محصولات باید تنظیمات ذیل انجام شود
۱. ایجاد پوشه اپلود
این پوشه در کنار پوشه سورس بایستی ایجاد شود

## naming requestmapping 
هم نام با کلاس کنترلر است تنها عبارت کنترلر در ان ذکر نمی شود


## requestcalls
1. {get}
   2. http://localhost:8080/f2f/relatedProducts/list?productId=1
2. {post}

## handle error for development
1.ExceptionHandlerExceptionResolver : Resolved [org.springframework.web.bind.MissingServletRequestParameterException: 
    Required String parameter 'productId' is not present]
    {production mode : ignore log the err}
    {development mode : log the error}

##properties
storage.properties ??