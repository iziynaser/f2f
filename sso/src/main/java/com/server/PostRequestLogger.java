package com.revengemission.sso.oauth2.server;

/*
    made by iziy
    copied from
    https://medium.com/@ThreePotatoteers/use-spring-aop-to-log-post-requests-6abee5753464
 */

public class PostRequestLogger{

}

//
//@Aspect
//@Component
//public class PostRequestLogger {
//
//    private Logger log = LoggerFactory.getLogger(this.getClass());
//
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
//    public void postAction() {
//    }
//
//    @Before("postAction()")
//    public void logAction(JoinPoint joinPoint) throws Throwable {
//        Class clazz = joinPoint.getTarget().getClass();
//        String url = getRequestUrl(joinPoint,clazz);
//        String payload = getPayload(joinPoint);
//        log.info("POST" + url + payload);
//    }
//
//    private String getRequestUrl(JoinPoint joinPoint,Class clazz){
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        Method method = methodSignature.getMethod();
//        PostMapping methodPostMapping = method.getAnnotation(PostMapping.class);
//        RequestMapping requestMapping = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
//        return getPostUrl(requestMapping,methodPostMapping);
//    }
//
//    private String getPayload(JoinPoint joinPoint){
//        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
//        StringBuilder builder = new StringBuilder();
//        for(int i=0;i<joinPoint.getArgs().length;i++){
//            String parmeterName = codeSignature.getParameterNames()[i];
//            builder.append(parmeterName);
//            builder.append(" : ");
//            builder.append(joinPoint.getArgs()[i].toString());
//            builder.append(",\n");
//        }
//        return builder.toString();
//    }
//
//    private String getPostUrl(RequestMapping requestMapping,PostMapping postMapping){
//        String baseUrl = getUrl(requestMapping.value());
//        String endpoint = getUrl(postMapping.value());
//        return baseUrl + endpoint ;
//    }
//
//    private String getUrl(String [] urls){
//        if(urls.length==0)
//            return "";
//        else
//            return urls[0];
//    }
//}
