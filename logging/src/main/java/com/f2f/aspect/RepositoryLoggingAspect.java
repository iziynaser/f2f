package com.f2f.aspect;

import com.f2f.model.LoggingModel;
import com.f2f.service.LoggingService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Arrays;

@Aspect
@Component
public class RepositoryLoggingAspect {

    private final LoggingService loggingService;

    public RepositoryLoggingAspect(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    // Pointcut برای تمام کلاس‌هایی که @Repository دارند
    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    public void repositoryClassMethods() {}

    // اجرای لاگ فقط در صورت خطا
    @AfterThrowing(pointcut = "repositoryClassMethods()", throwing = "ex")
    public void logRepositoryException(JoinPoint joinPoint, Throwable ex) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        String message = ex.getMessage();
        String stackTrace = Arrays.toString(ex.getStackTrace());

        // ایجاد مدل لاگ و ثبت در سرویس
        LoggingModel logModel = new LoggingModel();
        logModel.setLevel("ERROR");
        logModel.setClassName(className);
        logModel.setMethodName(methodName);
        logModel.setMessage(message);
        logModel.setExtendedInformation(stackTrace);
        logModel.setTimeStamp(Instant.now().toString());

        loggingService.log(logModel);
    }
}
