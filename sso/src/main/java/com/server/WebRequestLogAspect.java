package com.revengemission.sso.oauth2.server;

import com.revengemission.sso.oauth2.server.utils.ClientIpUtil;
import com.revengemission.sso.oauth2.server.utils.JsonUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

@Aspect
@Component
public class WebRequestLogAspect {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.revengemission.sso.oauth2.server.controller.*.*(..))")
    public void wsLog() {
    }

    /**
     * receive the request and record the request
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("wsLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        if (log.isInfoEnabled()) {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attributes != null) {
                //HttpServletRequest request = attributes.getRequest();
                //Map<String, String[]> parameters = request.getParameterMap();

                try {
                    String parametersString = null;
                    String requestBody = null;
//                    if (parameters != null) {
//                        parametersString = JsonUtil.multiValueMapToJsonString(parameters);
//                    }
                    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
                    //get blocked method
                    Method method = signature.getMethod();
                    Object object = getAnnotatedParameterValueRequestBody(method, joinPoint.getArgs());
                    if (object != null) {
                        requestBody = JsonUtil.objectToJsonString(object);
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("\nRequest from = ");
                    stringBuffer.append("ClientIpUtil.getIpAddress(request)");// stringBuffer.append(ClientIpUtil.getIpAddress(request));
                    stringBuffer.append(";\n");
                    stringBuffer.append("uri = ");
                    stringBuffer.append("request.getRequestURL().toString()");// stringBuffer.append(request.getRequestURL().toString());
                    stringBuffer.append(";\n");
                    stringBuffer.append("request method = ");
                    stringBuffer.append("request.getMethod()");// stringBuffer.append(request.getMethod());
                    stringBuffer.append(";\n");
                    stringBuffer.append("content type = ");
                    stringBuffer.append("request.getContentType()");//stringBuffer.append(request.getContentType());
                    stringBuffer.append(";\n");
                    stringBuffer.append("request parameters = ");
                    stringBuffer.append(parametersString);
                    stringBuffer.append(";\n");
                    stringBuffer.append("request body = ");
                    stringBuffer.append(requestBody);
                    stringBuffer.append(";\n");

                    //stringBuffer.append("request headers="+request.getHeaderNames())
                    stringBuffer.append("headers:{");
                    //Enumeration<String> headeNames = request.getHeaderNames();
//                    while(headeNames.hasMoreElements()){
//                        String headerName = headeNames.nextElement();
//                        String headerValue = request.getHeader(headerName);
//                        stringBuffer.append(headerName+":"+headerValue);
//                        stringBuffer.append(";\n");
//                    }
                    stringBuffer.append("}");

                    log.info(stringBuffer.toString());

                } catch (Exception e) {
                    log.info("log http request Exception: ", e);
                }
            }
        }
    }

    @AfterReturning(returning = "ret", pointcut = "wsLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // after processing the request , return the content
        if (log.isInfoEnabled()) {
            try {
                log.info("Response from server : \n" + JsonUtil.objectToJsonString(ret));
            } catch (Exception e) {
                log.info("log http response Exception:\n ", e);
            }
        }
    }

    private Object getAnnotatedParameterValueRequestBody(Method method, Object[] args) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        ///Parameter[] parameters = method.getParameters();

        int i = 0;
        for (Annotation[] annotations : parameterAnnotations) {
            Object arg = args[i];
            ///String name = parameters[i++].getDeclaringExecutable().getName();
            for (Annotation annotation : annotations) {
                if (annotation instanceof RequestBody) {
                    return arg;
                }
            }
        }
        return null;
    }


}
