package ir.verjik.aspect;

import ir.verjik.model.LoggingModel;
import ir.verjik.service.LoggingService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Aspect
@Component
public class LoggingAspect {

    @Autowired
    private LoggingService loggingService;

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void controllerPointcut() {}

    @Around("controllerPointcut()")
    public Object logControllerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result ;
        try {
            result = joinPoint.proceed();
            return result;
        }finally {
            long duration = System.currentTimeMillis() - startTime;
            LoggingModel model = new LoggingModel();
            model.setTimeStamp(Instant.now().toString());
            model.setClassName(joinPoint.getSignature().getDeclaringTypeName());
            model.setMethodName(joinPoint.getSignature().getName());
            model.setExecutionTime(duration);
            model.setLevel("INFO");

            loggingService.log(model);
        }
    }
}
