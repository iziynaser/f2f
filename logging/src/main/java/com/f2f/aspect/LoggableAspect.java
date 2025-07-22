package com.f2f.aspect;

import com.f2f.Loggable;
import com.f2f.model.LoggingModel;
import com.f2f.service.LoggingService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.Instant;
import java.util.Arrays;

@Aspect
@Component
public class LoggableAspect {

    private final LoggingService loggingService;

    public LoggableAspect(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @Around("@annotation(loggable)")
    public Object logAround(ProceedingJoinPoint joinPoint, Loggable loggable) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        long startTime = System.currentTimeMillis();

        try {
            Object result = joinPoint.proceed();

            if (loggable.logExecutionTime()) {
                LoggingModel log = new LoggingModel();
                log.setLevel(loggable.level());
                log.setClassName(method.getDeclaringClass().getSimpleName());
                log.setMethodName(method.getName());
                log.setExecutionTime(System.currentTimeMillis() - startTime);
                log.setMessage("Execution completed");
                log.setTimeStamp(Instant.now().toString());

                loggingService.log(log);
            }

            return result;

        } catch (Throwable ex) {
            if (loggable.logError()) {
                LoggingModel log = new LoggingModel();
                log.setLevel("ERROR");
                log.setClassName(method.getDeclaringClass().getSimpleName());
                log.setMethodName(method.getName());
                log.setMessage(ex.getMessage());
                log.setExtendedInformation(Arrays.toString(ex.getStackTrace()));
                log.setTimeStamp(Instant.now().toString());

                loggingService.log(log);
            }
            throw ex;
        }
    }
}
