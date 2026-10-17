package ir.verjik;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Loggable {
    boolean logExecutionTime() default true; // زمان اجرا لاگ شود؟
    boolean logError() default true;         // خطاها لاگ شوند؟
    String level() default "INFO";           // سطح لاگ
}
